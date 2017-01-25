package com.trygve.oving1;

import java.util.Calendar;

class Resturant {
    private String navnResturant;
    private int etableringsar;

    Bord bord;

    public Resturant(String navnResturant, int etableringsar, int antallBord) {

        if (navnResturant != null) navnResturant = navnResturant.trim();

        if (navnResturant == null || navnResturant.length() <= 0||  antallBord <= 0) throw new IllegalArgumentException();//exception

        this.navnResturant = navnResturant;
        this.etableringsar = etableringsar;
        this.bord = new Bord(antallBord);

    }

    public String getNavnResturant() {
        return navnResturant;
    }

    public void setNavnResturant(String navnResturant) {
        if (navnResturant != null) navnResturant = navnResturant.trim();

        if (navnResturant == null || navnResturant.length() <= 0) ;//exception

        this.navnResturant = navnResturant;
    }

    public int getEtableringsar() {
        return etableringsar;
    }

    public int getAlder() {
        return Calendar.getInstance().get(Calendar.YEAR) - etableringsar;
    }

    public int getLedigeBord() {
        int antall = 0;

        for (int i = 1; i <= bord.getAntallBord();i++) if (!bord.getRestervert(i)) antall++;

        return antall;
    }

    public int getOpptatteBord() {
        int antall = 0;

        for (int i = 1; i <= bord.getAntallBord();i++) if (bord.getRestervert(i)) antall++;

        return antall;
    }

    public int getTotaleBord() {
        return bord.getAntallBord();
    }

    public boolean reserverBord(String navn) {
        return reserverBord(navn, 1);
    }

    public boolean reserverBord(String navn, int antallBordSkalReserveres) {
        if (getLedigeBord() < antallBordSkalReserveres) return false;

        int antallReservert = 0;

        for (int i = 1; antallBordSkalReserveres > antallReservert && bord.getAntallBord() >= i;i++ ) {
            if (bord.reserverBord(i, navn)) antallReservert++;
        }

        return true;
    }

    public int[] finnReserverteBordNavn(String navn) {
        int[] bordNr = new int[0];

        for (int i = 1; i <= getTotaleBord(); i++ ) {
            if (bord.getRestervertNavn(i) != null && bord.getRestervertNavn(i).equals(navn)) {
                bordNr = expandArray(bordNr);
                bordNr[bordNr.length - 1] = i;
            }
        }

        return bordNr;
    }

    public String finnReserverteBordNummer(int bordNr) {
        return bord.getRestervertNavn(bordNr);
    }

    public void frigiBord(int[] bordNr) {
        for (int i = 0; i < bordNr.length;i++) bord.frigiBord(bordNr[i]);
    }

    private int[] expandArray(int[] oldArray) {
        int[] newArray = new int[oldArray.length + 1];

        for (int i = 0; i < oldArray.length; i++) newArray[i] = oldArray[i];

        return newArray;
    }
}