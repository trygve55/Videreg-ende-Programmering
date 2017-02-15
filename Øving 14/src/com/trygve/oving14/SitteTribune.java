package com.trygve.oving14;

/**
 * Created by Trygve on 15.02.2017.
 */
public class SitteTribune extends Tribune {
    private int antOpptatt[];
    private int lengdeRad;

    public SitteTribune(String tribuneNavn, int rader, int lengdeRad, int pris) {
        super(tribuneNavn, rader*lengdeRad,pris);
        antOpptatt = new int[rader];
        this.lengdeRad = lengdeRad;
    }

    public int finnAntallSolgteBilletter() {
        int antOpp = 0;
        for (int i = 0;i < antOpptatt.length;i++) antOpp += antOpptatt[i];
        return antOpp;
    }

    public Billett[] kjopBilleter(int antallBilletter) {
        for (int i = 0;i < antOpptatt.length;i++) {
            if (lengdeRad - antOpptatt[i] - antallBilletter >= 0) {
                Billett[] billetter = new Billett[antallBilletter];

                for (int j = 0;j < billetter.length;j++) {
                    antOpptatt[i]++;
                    billetter[j] = new SitteplassBillett(getTribuneNavn(), getPris(), i, antOpptatt[i]);
                }
                return billetter;
            }
        }
        return null;
    }
}
