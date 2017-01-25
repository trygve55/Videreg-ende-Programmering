package com.trygve.oving1;

public class  Bord {
    private String[] reservertNavn;

    public Bord(int antallBord) {
        this.reservertNavn = new String[antallBord];
    }

    public boolean reserverBord(int bordNr, String reservertNavn) {
        if (this.reservertNavn[bordNr - 1] != null) return false;

        this.reservertNavn[bordNr - 1] = reservertNavn;
        return true;
    }

    public boolean getRestervert(int bordNr) {
        return reservertNavn[bordNr - 1] != null;
    }

    public String getRestervertNavn(int bordNr) {
        return reservertNavn[bordNr - 1];
    }

    public boolean frigiBord(int bordNr) {
        this.reservertNavn[bordNr - 1] = null;
        return true;
    }

    public int getAntallBord() {
        return reservertNavn.length;
    }
}