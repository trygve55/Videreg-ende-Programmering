package com.trygve.oving17.dyrehage;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Trygve on 15.03.2017.
 */
public abstract class Individ extends Dyr implements SkandinaviskeRovdyr {
    private final String navn;
    private final Date fDato;
    private final boolean hanndyr;
    private final boolean farlig;

    public Individ(String norskNavn, String latNavn, String latFamilie, Date ankommetDato, String adresse, String navn, Date fDato, boolean hanndyr, boolean farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.navn = navn;
        this.fDato = fDato;
        this.hanndyr = hanndyr;
        this.farlig = farlig;
    }

    @Override
    public String getNavn() {
        return navn;
    }

    @Override
    public Date getFdato() {
        return fDato;
    }

    public boolean isHanndyr() {
        return hanndyr;
    }

    public boolean isFarlig() {
        return farlig;
    }

    @Override
    public String skrivUtInfo() {
        String ut = super.toString() + "\n";
        ut += "Navn: " + getNavn() + "\nFødselsdato: " + getFdato() + "\nAlder: " + getAlder();
        if(isFarlig()){
            ut += "\n" + getNavn() + " er farlig.";
        }else ut += "\n" + getNavn() + " er ikke farlig.";
        if(isHanndyr()){
            ut += "\nKjønn: hann.";
        }else ut += "\nKjønn: hunn.";
        return ut;
    }

    @Override
    public void flytt(String adresse) {
        setAdresse(adresse);
    }

    @Override
    public int getAlder() {
        return (int) Math.floor((double) (Calendar.getInstance().getTime().getTime() - getFdato().getTime()) / (1000.0 * 60.0 * 60.0 * 24.0 * 365.25));
    }

    public String getAdresse() {
        return "";
    }

}
