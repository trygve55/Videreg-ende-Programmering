package com.trygve.oving17.dyrehage;

import java.util.Date;

/**
 * Created by Trygve on 15.03.2017.
 */
public class Fiskestim extends Dyregruppe {
    private final double gjennomsnittligLengde;
    private final boolean kanDeleAkvarium;

    public Fiskestim(String norskNavn, String latNavn, String latFamilie, Date ankommetDato, String adresse, String gruppenavn, int antIndivider, double gjennomsnittligLengde, boolean kanDeleAkvarium) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, gruppenavn, antIndivider);
        this.gjennomsnittligLengde = gjennomsnittligLengde;
        this.kanDeleAkvarium = kanDeleAkvarium;
    }

    public double getGjennomsnittligLengde() {
        return gjennomsnittligLengde;
    }

    public boolean isKanDeleAkvarium() {
        return kanDeleAkvarium;
    }
}
