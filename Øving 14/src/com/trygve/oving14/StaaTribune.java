package com.trygve.oving14;

/**
 * Created by Trygve on 15.02.2017.
 */
public class StaaTribune extends Tribune {
    private int antallSolgteBiletter = 0;

    public StaaTribune(String tribuneNavn, int kapasitet, int pris) {
        super(tribuneNavn, kapasitet,pris);
    }

    public int finnAntallSolgteBilletter() {
        return antallSolgteBiletter;
    }

    public Billett[] kjopBilleter(int antallBilletter) {
        if (getKapasitet() - antallBilletter < antallBilletter) return null;

        Billett[] billetter = new Billett[antallBilletter];
        antallSolgteBiletter += antallBilletter;

        for (int i = 0;i < billetter.length;i++) billetter[i] = new StaaplassBillett(getTribuneNavn(), getPris());

        return billetter;
    }
}
