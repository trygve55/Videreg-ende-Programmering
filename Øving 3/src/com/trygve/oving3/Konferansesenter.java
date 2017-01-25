package com.trygve.oving3;

import java.util.ArrayList;

/**
 * Created by Trygve on 18.01.2017.
 */
public class Konferansesenter {
    ArrayList<Rom> rom = new ArrayList<Rom>();

    public int reserverRom(long fratid, long tilTid, int antallPersoner, String navn, String tlfNummer) {
        Kunde kunde = new Kunde(navn, tlfNummer);
        Reservasjon reservasjon = new Reservasjon(new Tidspunkt(fratid), new Tidspunkt(tilTid), kunde);

        for (Rom r: rom) {
            if (r.getStorrelse() >= antallPersoner && r.addReservasjon(reservasjon)) return r.getRomNr();
        }
        return -1;
    }

    public boolean registrerRom(int romNr, int storrelse) {
        for (Rom r: rom) if (r.equals(romNr)) return false;
        return rom.add(new Rom(romNr, storrelse));
    }

    public int getAntallRom() {
        return rom.size();
    }

    public String getRomIndex(int i) {
        if (rom.get(i) != null) return rom.get(i).toString();
        return null;
    }

    public String getRomNr(int romNr) {
        for (int i = 0; i < rom.size();i++) if (rom.get(i).getRomNr() == romNr) return rom.get(i).toString();
        return null;
    }

    public String toString() {
        String returnString = "Konferansesenteret har " + getAntallRom() + " rom.\n";
        for (Rom r: rom) returnString += r.toString();
        return returnString;
    }

    public static void main(String[] args) {
        Konferansesenter konferansesenter = new Konferansesenter();

        boolean test1 = (konferansesenter.registrerRom(1337, 2) && !konferansesenter.registrerRom(1337, 5) );
        boolean test2 = (konferansesenter.registrerRom(404, 5));

        boolean test3 = (konferansesenter.reserverRom(201612021100L , 201612061900L, 4, "Ola Nordmann", "13371337") != -1 && konferansesenter.reserverRom(201612031100L , 201612051900L, 4, "Ola Nordmann", "13371337") != -1 );

        System.out.println(" Test 1: " + (test1 ? "virker" : "virker ikke"));
        System.out.println(" Test 2: " + (test2 ? "virker" : "virker ikke"));
        System.out.println(" Test 3: " + (test3 ? "virker" : "virker ikke"));


        System.out.println("\n" + konferansesenter.toString());
    }
}
