package dades.Associacions;

import dades.Membres.*;

// Hecho por Alex Radu

// TODO Explicaciones de los metodos correctas

public class Associacio {
    private static final String[] TITULACIONS_VALIDES = {"GEB", "GEI", "GESST", "BioGEI", "DG GEB-GESST", "extern-ETSE"};
    private String nom; // Nom de l'associació
    private String correuContacte; // Correu electrònic de contacte
    private String[] titulacions; // Titulacions associades a la associació

    private LlistaMembres membres; // Llista de membres

    private Alumnes president; // Alumne que ocupa el càrrec de president
    private Alumnes secretari; // Alumne que ocupa el càrrec de secretari
    private Alumnes tresorer; // Alumne que ocupa el càrrec de tresorer

    public Associacio (String nom, String correuContacte, int maxMembres){
        this.nom = nom;
        this.correuContacte = correuContacte;
        this.membres = new LlistaMembres(nom, maxMembres);
        titulacions = new String[TITULACIONS_VALIDES.length];
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCorreuContacte(String correuContacte) {
        this.correuContacte = correuContacte;
    }
    
    //Getters
    public String getNom() {
        return nom;
    }

    public String getCorreuContacte() {
        return correuContacte;
    }

    public String[] getTitulacions() {
        return titulacions;
    }

    public Alumnes getPresident() {
        return president.copia();
    }

    public Alumnes getSecretari() {
        return secretari.copia();
    }

    public Alumnes getTresorer() {
        return tresorer.copia();
    }

    //Metodes auxiliars
    private boolean esTitulacioValida(String titulacio) {
        for (String valida : TITULACIONS_VALIDES) {
            if (valida.equalsIgnoreCase(titulacio)) {
                return true;
            }
        }
        return false;
    }

    private void validarAssignacio(Membres membre, String rol) {
        if (!(membre instanceof Alumnes)) {
            throw new IllegalArgumentException("Només un alumne pot ser " + rol + ".");
        }
        if (!membres.esta(membre)) {
            throw new IllegalArgumentException("El " + rol + " ha de ser membre de l'associació.");
        }
    }

    private boolean titulacioJaRegistrada(String titulacio) {
        for (String tit : titulacions) {
            if (tit != null && tit.equalsIgnoreCase(titulacio)) {
                return true;
            }
        }
        return false;
    }

    public void afegirTitulacio(String titulacio) {
        try {
            if (titulacio == null || titulacio.isEmpty()) {
                throw new IllegalArgumentException("La titulació no pot ser buida.");
            }
        
            if (!esTitulacioValida(titulacio)) {
                throw new IllegalArgumentException("Titulació no vàlida: " + titulacio);
            }
        
            // Afegir titulació al primer espai lliure
            for (int i = 0; i < titulacions.length; i++) {
                if (titulacions[i] == null) {
                    titulacions[i] = titulacio;
                    return;
                }
            }
            throw new IllegalStateException("No es poden afegir més titulacions.");
        } catch (Exception e) {
            System.err.println("Error afegint titulació: " + e.getMessage());
        }
    }

    public void afegirMembre(Membres membre) {
        try {
            membres.afegirMembre(membre); // Afegir membre a la llista
    
            if (membre instanceof Alumnes) {
                String titulacio = ((Alumnes) membre).getEnsenyament();
                if(!titulacioJaRegistrada(titulacio)) {
                    afegirTitulacio(titulacio);
                }
            }
        } catch (Exception e) {
            System.err.println("Error afegint membre: " + e.getMessage());
        }
    }    

    // Métodos para asignar cargos
    public void assignarPresident(Membres membre) {
        validarAssignacio(membre, "president");
         this.president = (Alumnes) membre.copia();
    }

    public void assignarSecretari(Membres membre) {
        validarAssignacio(membre, "secretari");
        this.secretari = (Alumnes) membre.copia();
    }

    public void assignarTresorer(Membres membre) {
        validarAssignacio(membre, "tresorer");
        this.tresorer = (Alumnes) membre.copia();
    }

    // Métodos para asignar cargos por alias 
    // Implementar buscarPerAlias en llista membres
    /*
    public void assignarPresident(String alias) {
        Membres membre = membres.buscarPerAlias(alias);
        if (membre instanceof Alumnes) {
            this.president = (Alumnes) membre;
        } else {
            throw new IllegalArgumentException("El president ha de ser un alumne i membre de l'associació.");
        }
    }

    public void assignarSecretari(String alias) {
        Membres membre = membres.buscarPerAlias(alias);
        if (membre instanceof Alumnes) {
            this.secretari = (Alumnes) membre;
        } else {
            throw new IllegalArgumentException("El secretari ha de ser un alumne i membre de l'associació.");
        }
    }

    public void assignarTresorer(String alias) {
        Membres membre = membres.buscarPerAlias(alias);
        if (membre instanceof Alumnes) {
            this.tresorer = (Alumnes) membre;
        } else {
            throw new IllegalArgumentException("El tresorer ha de ser un alumne i membre de l'associació.");
        }
    }
    */
}

