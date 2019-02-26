package com.example.appalimentosdb.JavaBean;

import java.io.Serializable;

public class Alimentacion implements Serializable {
    private int idA;
    private String nameA;
    private String tipoA;
    private  String origenA;
    private  String nutrientesA;
    private  String funcionA;

    public Alimentacion(int idA, String nameA, String tipoA, String origenA, String nutrientesA, String funcionA) {
        this.idA = idA;
        this.nameA = nameA;
        this.tipoA = tipoA;
        this.origenA = origenA;
        this.nutrientesA = nutrientesA;
        this.funcionA = funcionA;
    }

    public Alimentacion(String nameA, String tipoA, String origenA, String nutrientesA, String funcionA) {
        idA = -1 ;
        this.nameA = nameA;
        this.tipoA = tipoA;
        this.origenA = origenA;
        this.nutrientesA = nutrientesA;
        this.funcionA = funcionA;
    }


    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getTipoA() {
        return tipoA;
    }

    public void setTipoA(String tipoA) {
        this.tipoA = tipoA;
    }

    public String getOrigenA() {
        return origenA;
    }

    public void setOrigenA(String origenA) {
        this.origenA = origenA;
    }

    public String getNutrientesA() {
        return nutrientesA;
    }

    public void setNutrientesA(String nutrientesA) {
        this.nutrientesA = nutrientesA;
    }

    public String getFuncionA() {
        return funcionA;
    }

    public void setFuncionA(String funcionA) {
        this.funcionA = funcionA;
    }
}
