package com.trygve.oving6;

/**
 * Created by Trygve on 25.01.2017.
 */
public class Valuta {
    private String valutaName;
    private double valutaMotNorske, norskeKr;


    public Valuta(String valutaName, double valutaMotNorske, double norskeKr) {
        this.valutaName = valutaName;
        this.valutaMotNorske = valutaMotNorske;
        this.norskeKr = norskeKr;
    }

    public String getValutaName() {
        return valutaName;
    }

    public double getValutaMotNorske() {
        return valutaMotNorske;
    }

    public double getNorskeKr() {
        return norskeKr;
    }

    public double convertToValuta(Valuta valuta, double belop) {
        return belop * (getValutaMotNorske() / getNorskeKr()) / (valuta.getValutaMotNorske() / valuta.getNorskeKr());
    }

    public String toString() {
        return valutaName;
    }

    public boolean equals(Valuta valuta) {
        return (valutaName == valuta.getValutaName());
    }
}
