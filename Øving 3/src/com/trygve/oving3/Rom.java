package com.trygve.oving3;

import java.util.ArrayList;

/**
 * Created by Trygve on 18.01.2017.
 */
public class Rom {
    private final int romNr, storrelse;

    private ArrayList<Reservasjon> reservasjoner = new ArrayList<Reservasjon>();

    public Rom(int romNr, int storrelse) {
        this.romNr = romNr;
        this.storrelse = storrelse;
    }

    public boolean addReservasjon(Reservasjon reservasjon) {
        for (com.trygve.oving3.Reservasjon r: reservasjoner) if (r.overlapp(reservasjon.getFraTid(), reservasjon.getTilTid())) return false;
        return reservasjoner.add(reservasjon);
    }

    public int getRomNr() {
        return  romNr;
    }

    public int getStorrelse() {
        return storrelse;
    }

    public String toString() {
        String returnString = "Rom nummer: " + romNr + " Størrelse: " + storrelse + "\n";
        for (Reservasjon r: reservasjoner) returnString += "  "  + r.toString() + "\n";
        return  returnString;
    }

    public boolean equals(int romNr) {
        return (this.romNr == romNr);
    }

    public static void main(String[] args) {
        Rom rom = new Rom(1337, 5);
        Kunde k = new Kunde("Anne Hansen", "12345678");
        Reservasjon r1 = new Reservasjon(new Tidspunkt(200302011000L), new Tidspunkt(200302011100L), k);
        Reservasjon r2 = new Reservasjon(new Tidspunkt(200301211000L), new Tidspunkt(200301211030L), k);
        Reservasjon r3 = new Reservasjon(new Tidspunkt(200302011130L), new Tidspunkt(200302011300L), k);
        Reservasjon r4 = new Reservasjon(new Tidspunkt(200302010900L), new Tidspunkt(200302011100L), k);

        rom.addReservasjon(r1);
        rom.addReservasjon(r2);
        rom.addReservasjon(r3);
        rom.addReservasjon(r4);

        System.out.println(rom.toString());

    }
}
