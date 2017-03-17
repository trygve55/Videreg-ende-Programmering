package com.trygve.oving17.dyrehage;

import java.util.Date;

/**
 * Created by Trygve on 15.03.2017.
 */
public class Dyregruppe extends Dyr {
    private final String gruppenavn;
    private int antIndivider;

    public Dyregruppe(String norskNavn, String latNavn, String latFamilie, Date ankommetDato, String adresse, String gruppenavn, int antIndivider) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gruppenavn = gruppenavn;
        this.antIndivider = antIndivider;
    }

    public String getNorskNavn(){
        return "Gruppe av " + super.getNorskNavn();
    }

    public String getGruppenavn() {
        return gruppenavn;
    }

    public int getAntIndivider() {
        return antIndivider;
    }

    public void setAntIndivider(int antIndivider) {
        this.antIndivider = antIndivider;
    }
}
