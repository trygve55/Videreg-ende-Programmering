package com.trygve.oving12oppg1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Trygve on 14.02.2017.
 */
public class Medlemsarkiv {

    ArrayList<BonusMedlem> medlemer = new ArrayList<BonusMedlem>();

    public Medlemsarkiv() {

    }

    public int nyMedlem(Personalia pers, LocalDate innmeldt) {
        int medlNr = finnLedigNr();
        medlemer.add(new BasicMedlem(medlNr, pers, innmeldt));
        return medlNr;
    }

    public int finnPoeng(int medlNr, String passord) {
        for (BonusMedlem m: medlemer) {
            if (m.getMedlnr() == medlNr && m.okPassord(passord)) return m.getPoeng();
        }
        return -1;
    }

    public boolean registrerPoeng(int medlNr, int poeng) {
        for (BonusMedlem m: medlemer) {
            if (m.getMedlnr() == medlNr) {
                m.registrerPoeng(poeng);
                return true;
            }
        }
        return false;
    }

    public void sjekkMedlemmer(LocalDate localDate) {
        for (int i = 0; i < medlemer.size(); i++) {
            if (medlemer.get(i) == null) continue;
            BonusMedlem m = medlemer.get(i);
            if (m.finnKvalPoeng(localDate) >= 75000 && !(m instanceof GullMedlem)) {
                medlemer.set(i, new GullMedlem(m.getMedlnr(), m.getPers(), m.getInnmeldtDato(), m.getPoeng()));
            } else if (m.finnKvalPoeng(localDate) >= 25000 && (m instanceof BasicMedlem)) {
                medlemer.set(i, new SoelvMedlem(m.getMedlnr(), m.getPers(), m.getInnmeldtDato(), m.getPoeng()));
            }
        }
    }

    private int finnLedigNr() {
        Random rand = new Random();
        int nr;
        do {
            nr = rand.nextInt(Integer.MAX_VALUE);
        } while (isMedlNr(nr));
        return nr;
    }

    private boolean isMedlNr(int medlNr) {
        for (BonusMedlem m: medlemer) if (medlNr == m.getMedlnr()) return true;
        return false;
    }
}
