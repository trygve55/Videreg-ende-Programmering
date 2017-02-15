package com.trygve.oving14;

/**
 * Created by Trygve on 15.02.2017.
 */
public class VIPTribune extends Tribune {
    private String[][] tilskuer;

    public VIPTribune(String tribuneNavn, int rader, int lengdeRad, int pris) {
        super(tribuneNavn, rader*lengdeRad,pris);
        tilskuer = new String[rader][lengdeRad];
    }

    public int finnAntallSolgteBilletter() {
        int antSolgt = 0;
        for (int i = 0;i < tilskuer.length;i++) {
            for (int j = 0;j < tilskuer[0].length;j++) {
                if (tilskuer[i][j] != null) antSolgt++;
            }
        }
        return antSolgt;
    }

    public Billett[] kjopBilleter(int antallBilletter) {
        return null;
    }

    public Billett[] kjopBilleter(String[] navn) {
        for (int i = 0;i < navn.length; i++) if (navn[i] == null) return null;

        int navnNr = 0;

        for (int i = 0;i < tilskuer.length;i++) {
            if (tilskuer[i].length - antSolgtRad(i) >= navn.length) {
                Billett[] billetter = new Billett[navn.length];

                for (int j = antSolgtRad(i);j < billetter.length;j++) {
                    tilskuer[i][j] = navn[navnNr];
                    navnNr++;
                    billetter[j] = new SitteplassBillett(getTribuneNavn(), getPris(), i, antSolgtRad(i));
                }
                return billetter;
            }
        }
        return null;
    }

    private int antSolgtRad(int rad) {
        int antSolgt = 0;
        for (int j = 0;j < tilskuer[0].length;j++) {
            if (tilskuer[rad][j] != null) antSolgt++;
        }
        return antSolgt;
    }
}
