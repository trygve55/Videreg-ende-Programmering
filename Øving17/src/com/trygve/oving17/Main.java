package com.trygve.oving17;

import com.trygve.oving17.dyrehage.*;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Rovdyrfabrikk rovdyrfabrikk = new Rovdyrfabrikk();

        SkandinaviskeRovdyr rovdyr1 = rovdyrfabrikk.nyBinne("Bur 1", "Olga", new Date(99, 03, 04));
        SkandinaviskeRovdyr rovdyr2 = rovdyrfabrikk.nyUlvetispe("Bur 2", "Wolga", new Date(99, 02, 04));

        rovdyr1.leggTilKull(2);
        rovdyr2.leggTilNyttKull();
        System.out.println("\n" + rovdyr1.skrivUtInfo() + "\n");
        System.out.println("\n" + rovdyr2.skrivUtInfo() + "\n");
    }
}
