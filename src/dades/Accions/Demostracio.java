package dades.Accions;

import dades.Associacions.*;
import dades.Membres.*;

public class Demostracio extends Accio {
    private String dataDisseny;
    private boolean esValida;
    private int vegadesOferida;
    private double costMaterials;

    public Demostracio(String titol, Associacio associacio, Membres responsable, String dataDisseny, boolean esValida, double costMaterials) {
        super(titol, associacio, responsable);
        this.dataDisseny = dataDisseny;
        this.esValida = esValida;
        this.vegadesOferida = 0;
        this.costMaterials = costMaterials;
    }

    public void incrementarVegadesOferida() {
        vegadesOferida++;
    }

    public String getDataDisseny() {
        return dataDisseny;
    }

    public boolean isEsValida() {
        return esValida;
    }

    public int getVegadesOferida() {
        return vegadesOferida;
    }

    public double getCostMaterials() {
        return costMaterials;
    }

    @Override
    public String toString() {
        return super.toString() + ", Data Disseny=" + dataDisseny + ", És Vàlida=" + esValida + ", Vegades Oferida=" + vegadesOferida + ", Cost Materials=" + costMaterials;
    }
}
