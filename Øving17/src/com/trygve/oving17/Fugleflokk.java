package com.trygve.oving17.dyrehage;

import java.util.Date;

/**
 * Created by Trygve on 15.03.2017.
 */
public class Fugleflokk extends Dyregruppe {
    private final double gjennomsnittligVekt;
    private final boolean svommer;

    public Fugleflokk(String norskNavn, String latNavn, String latFamilie, Date ankommetDato, String adresse, String gruppenavn, int antIndivider, double gjennomsnittligVekt, boolean svommer) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, gruppenavn, antIndivider);
        this.gjennomsnittligVekt = gjennomsnittligVekt;
        this.svommer = svommer;
    }

    public double getGjennomsnittligVekt() {
        return gjennomsnittligVekt;
    }

    public boolean isSvommer() {
        return svommer;
    }
}
