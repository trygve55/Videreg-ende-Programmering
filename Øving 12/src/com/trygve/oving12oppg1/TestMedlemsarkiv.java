package com.trygve.oving12oppg1;

import java.time.LocalDate;

public class TestMedlemsarkiv {

    public static void main(String[] args) {
        Medlemsarkiv medlemsarkiv = new Medlemsarkiv();

        Personalia ole = new Personalia("Olsen", "Ole", "ole.olsen@dot.com", "ole");
        LocalDate testdato = LocalDate.of(2008, 2, 10);

        System.out.println("Totalt antall tester: 6");

        int medlNr1 = medlemsarkiv.nyMedlem(ole, testdato);
        medlemsarkiv.registrerPoeng(medlNr1, 25000);
        if (medlemsarkiv.finnPoeng(medlNr1, "ole") == 25000) {
            System.out.println("Test 1 ok");
        }

        if (medlemsarkiv.finnPoeng(medlNr1, "passord") == -1) {
            System.out.println("Test 2 ok");
        }

        if (medlemsarkiv.finnPoeng(123, "passord") == -1) {
            System.out.println("Test 3 ok");
        }

        medlemsarkiv.sjekkMedlemmer(LocalDate.of(2009, 5, 12));
        medlemsarkiv.registrerPoeng(medlNr1, 45000);
        if (medlemsarkiv.finnPoeng(medlNr1, "ole") == 70000) {
            System.out.println("Test 4 ok");
        }

        medlemsarkiv.registrerPoeng(medlNr1, 5000);
        medlemsarkiv.sjekkMedlemmer(LocalDate.of(2008, 5, 12));
        medlemsarkiv.registrerPoeng(medlNr1, 3000);
        if (medlemsarkiv.finnPoeng(medlNr1, "ole") == 79500) {
            System.out.println("Test 5 ok");
        }

        if (!medlemsarkiv.registrerPoeng(123, 45253)) {
            System.out.println("Test 6 ok");
        }

        medlemsarkiv.sjekkMedlemmer(LocalDate.of(2008, 5, 12));
        medlemsarkiv.registrerPoeng(medlNr1, 1000);
        if (medlemsarkiv.finnPoeng(medlNr1, "ole") == 80500) {
            System.out.println("Test 7 ok");
        }
    }
}
