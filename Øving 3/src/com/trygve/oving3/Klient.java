package com.trygve.oving3;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Klient {

    public static void main(String[] args) {
        Konferansesenter konferansesenter = new Konferansesenter();
        Input input = new Input();

        konferansesenter.registrerRom(42, 5);

        boolean exit = false;

        while (!exit) {

            int valg = input.getInt("1 - Reserver rom \n2 - Vis alle rom og reservasjoner \n3 - Register rom \n4 - Vis info om rom (rom nummer) \n5 - Vis info om rom (index) \n0 - Avslutt \n", 0, 5);

                switch (valg) {
                    case 0:     exit = true;    break;

                    case 1: long currentTime = Long.parseLong(new SimpleDateFormat("yyyyMMddhhmm").format(Calendar.getInstance().getTime()));
                            long fraTid = input.getLong("Start tid på reservsasjon (ÅÅÅÅMMDDTTmm): ", currentTime ,206001010000L), tilTid = input.getLong("Slutt tid på reservsasjon (ÅÅÅÅMMDDTTmm): ",fraTid ,206001010000L);
                            int antallPersoner = input.getInt("Hvor mange personer skal det være? (mellom 1 og 5000)", 1, 5000);
                            String navn = input.getString("Navn: "), tlfNummer = input.getString("Telefon nummer: ");

                            int returnCode = konferansesenter.reserverRom(fraTid, tilTid, antallPersoner, navn, tlfNummer);
                            if (returnCode == -1) System.out.println("Kunne ikke finne stor nokk eller ledig rom mellom disse tidspunktene.\n");
                            else System.out.println("Rom nummer " + returnCode + " ble reservert.");
                        break;

                    case 2: System.out.println(konferansesenter.toString());
                        break;

                    case 3: int romNummer = input.getInt("Nummer på nytt rom:", 0, 9999), storrelse = input.getInt("Størelse på nytt rom:", 1, 50000);

                            if (konferansesenter.registrerRom(romNummer,storrelse)) {
                                System.out.println("Rom registert: " + konferansesenter.getRomNr(romNummer));
                            } else {
                                System.out.println("Rom med samme nummer eksisterer allerede.\n");
                            }
                        break;

                    case 4: int romNummer2 = -1;
                            do {
                                try {
                                    romNummer2 = input.getInt("Rom Nummer: ");
                                } catch (Exception e) {
                                    System.out.println("Rom nummer må være et tall over -1.");
                                }
                            } while (romNummer2 == - 1);
                            String string = konferansesenter.getRomNr(romNummer2);
                            if (string != null) System.out.println(string);
                        break;

                    case 5: int index = -1;
                            do {
                                try {
                                    index = input.getInt("Rom index: ");
                                } catch (Exception e) {
                                    System.out.println("Rom nummer må være et tall over -1.");
                                }
                            } while (index == - 1);
                            String string2 = konferansesenter.getRomIndex(index);
                            if (string2 != null) System.out.println(string2);
                        break;
                }
        }

        System.out.println(konferansesenter.toString());
    }
}
