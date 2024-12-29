package dades.Accions;

import dades.Associacions.*;
import dades.Membres.*;

public abstract class Accio {
    private static int codiCounter = 100;
    private String codi;
    private String titol;
    private Associacio associacio;
    private Membres responsable;

    public Accio(String titol, Associacio associacio, Membres responsable) {
        this.titol = titol;
        this.associacio = associacio;
        this.responsable = responsable;
        this.codi = generarCodi(associacio);
    }

    private String generarCodi(Associacio associacio) {
        return associacio.getNomAsociacio().substring(0, 3).toUpperCase() + (codiCounter++);
    }

    public String getCodi() {
        return codi;
    }

    public String getTitol() {
        return titol;
    }

    public Associacio getAssociacio() {
        return associacio;
    }

    public Membres getResponsable() {
        return responsable;
    }

    @Override
    public String toString() {
        return "Acció [Codi=" + codi + ", Títol=" + titol + ", Associació=" + associacio.getNomAsociacio() + ", Responsable=" + responsable.getAlias() + "]";
    }
}


// TODO 1 revisar los test, y corregir errores del código 
