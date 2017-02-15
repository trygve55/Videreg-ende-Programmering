package com.trygve.oving12oppg1;

import java.time.LocalDate;
import java.time.Period;

public abstract class BonusMedlem {
    private final int medlNr;
    private final LocalDate innmeldtDato;
    private final Personalia personalia;
    private int poeng;
    private int poengMultiplier; //percent

    public BonusMedlem(int medlNr, Personalia personalia, LocalDate innmeldtDato, int poengMultiplier, int poeng) {
        this.medlNr = medlNr;
        this.personalia = personalia;
        this.innmeldtDato = innmeldtDato;
        this.poeng = poeng;
        this.poengMultiplier = poengMultiplier;
    }

    public int getPoeng() {
        return poeng;
    }

    public int getMedlnr() {
        return medlNr;
    }

    public LocalDate getInnmeldtDato() {
        return innmeldtDato;
    }

    public Personalia getPers() {
        return personalia;
    }

    public void registrerPoeng(int poeng) {
        if (this.poeng + poeng*poengMultiplier/100 < 0) throw new IllegalArgumentException("Poeng can't be negative for member.");
        this.poeng += (poeng*poengMultiplier)/100;
    }

    public int finnKvalPoeng(LocalDate localDate) {
        Period p = Period.between(innmeldtDato, localDate);
        if ((p.getYears()*365 + p.getMonths()*30 + p.getDays()) < 365) {
            return poeng;
        }
        return 0;
    }

    public boolean okPassord(String passord) {
        return personalia.okPassord(passord);
    }
}
