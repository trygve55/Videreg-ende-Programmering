package com.trygve.oving1;

class Main {
    public static void main(String[] args) {
        Input input = new Input();
        //Resturant resturant;
       /* do {
            try {
                resturant = new Resturant(input.getString("Navn på resturanten?"), input.getInt("Når ble resturanten etablert?"), input.getInt("Hvor mange bord er det på resturanten?"));
            } catch (IllegalArgumentException e) {
                resturant = null;
                System.out.println("Feil i argumenter.");
            }
        } while (resturant == null);*/

        Resturant resturant = new Resturant("Ost", 2003, 5);

        boolean exit = false;


        while (!exit) {
            // try {
            String navn = "";
            int antall = 0;
            int choose = -2;

            while (choose < 0 || choose  > 6) {
                try {
                    choose = input.getInt("\n1 - Info om resturant \n2 - Info om bord \n3 - Reserver bord. \n4 - Vis reservasjoner \n5 - Vis reservasjoner på navn \n6 - Frigi bord \n0 - Avslutt");
                } catch (Exception e) {

                }
            }

            switch (choose) {
                case 0: exit = true; break;

                case 1: System.out.println("Resturant navn: " + resturant.getNavnResturant() + "\nEtablert: " + resturant.getEtableringsar() + "\nAlder: " + resturant.getAlder()); break;

                case 2:  System.out.println("Ledige bord: " + resturant.getLedigeBord() + "\nOpptatte bord: " + resturant.getOpptatteBord() + "\nTotale bord: " + resturant.getTotaleBord()); break;

                case 3:

                    do {
                        navn = input.getString("Hvem reserverer?").trim();
                    } while  (navn.length() == 0);

                    do {
                        antall = input.getInt("Hvor mange bord?");
                    } while  (antall <= 0);

                    if (resturant.reserverBord(navn, antall)) {
                        System.out.println("\nBord reservert for " + navn + ".");
                        int[] bordNr = resturant.finnReserverteBordNavn(navn);
                        System.out.print("Bordnummer: ");
                        for (int i = 0; i < bordNr.length;i++) {
                            System.out.print(bordNr[i]);
                            if (i < bordNr.length - 1) System.out.print(", ");
                        }
                        System.out.println(".");
                    } else {
                        System.out.println("\nBord kunne ikke bli reservert.");
                    }						break;

                case 4:
                    for (int bordNr = 1;bordNr <= resturant.getTotaleBord();bordNr++) {
                        String name = resturant.finnReserverteBordNummer(bordNr);
                        System.out.print("Bord " + bordNr + " - ");
                        if (name == null) System.out.println("Ledig");
                        else System.out.println("Reservert av " + name + ".");
                    }
                    break;

                case 5:
                    do {
                        navn = input.getString("Hvem reserverte?").trim();
                    } while  (navn.length() == 0);


                    int[] bordNrRelease = resturant.finnReserverteBordNavn(navn);
                    if (bordNrRelease.length > 0) {
                        System.out.print("\nBord reservert for " + navn + ": ");
                        for (int i = 0; i < bordNrRelease.length; i++) {
                            System.out.print(bordNrRelease[i]);
                            if (i < bordNrRelease.length - 1) System.out.print(", ");
                        }
                        System.out.println(".");
                    } else {
                        System.out.println("Ingen bord reservert for " + navn + ".");
                    }

                    break;

                case 6:
                    String releaseInput = input.getString("Navn eller bordnummer(separert med mellomrom): ").trim();
                    String[] releaseInputArray = releaseInput.split(" ");
                    int[] bordNr = new int[releaseInputArray.length];
                    boolean byName = false;
                    try {
                        for (int i = 0; i < releaseInputArray.length; i++) {
                            bordNr[i] = Integer.parseInt(releaseInputArray[i]);
                        }
                        resturant.frigiBord(bordNr);
                    } catch (Exception e) {
                        bordNr = resturant.finnReserverteBordNavn(releaseInput);
                        resturant.frigiBord(bordNr);
                    }



                    if (bordNr.length > 0) {
                        System.out.print("\nBord nummer frigit: ");
                        for (int i = 0; i < bordNr.length; i++) {
                            System.out.print(bordNr[i]);
                            if (i < bordNr.length - 1) System.out.print(", ");
                        }
                        System.out.println(".");
                    } else {
                        System.out.println("Ingen bord frigit.");
                    }
                    break;

            }
            // } catch (Exception e) {
            // System.out.println(e.getCause().getMessage());
            // }
        }
    }
}