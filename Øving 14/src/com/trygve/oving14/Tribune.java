package com.trygve.oving14;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Trygve on 15.02.2017.
 */
public abstract class Tribune  implements Comparable<Tribune>, Serializable {
    private final String tribuneNavn;
    private final int kapasitet;
    private final int pris;

    public Tribune(String tribuneNavn, int kapasitet, int pris) {
        this.tribuneNavn = tribuneNavn;
        this.kapasitet = kapasitet;
        this.pris = pris;
    }

    public int finnAntallSolgteBilletter() {
        return 0;
    }

    public int finnIntekt() {
        return finnAntallSolgteBilletter()*getPris();
    }

    public Billett[] kjopBilleter(int antallBilletter) {
        return null;
    }

    public Billett[] kjopBilleter(String[] navn) {
        for (int i = 0;i < navn.length; i++) if (navn[i] == null) return null;
        return kjopBilleter(navn.length);
    }

    public String getTribuneNavn() {
        return tribuneNavn;
    }

    public int getKapasitet() {
        return kapasitet;
    }

    public int getPris() {
        return pris;
    }

    public String toString() {
        return "Tribune: " + getTribuneNavn() + ", Kapasitet: " + getKapasitet() + ", Solgte billetter: " + finnAntallSolgteBilletter() + ", Inntekt: " + finnIntekt();
    }

    public int compareTo(Tribune to) {
        return (finnIntekt() - to.finnIntekt());
    }
}
