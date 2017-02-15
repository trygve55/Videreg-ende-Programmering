package com.trygve.oving14;

import java.util.ArrayList;
import java.util.Collections;

public class Main{

    public static void main(String[] args) {
        ArrayList<Tribune> tribuner = new ArrayList<Tribune>();
        FileIO file = new FileIO();

	    tribuner.add(new StaaTribune("West", 50, 100));
        tribuner.add(new StaaTribune("East", 30, 80));
        tribuner.add(new SitteTribune("Sitte South", 4, 12, 180));
        tribuner.add(new VIPTribune("VIP Best Korea", 3, 5, 380));

        for (Tribune t: tribuner) System.out.println(t);

        System.out.println("\nTester totalt: ");

        tribuner.get(0).kjopBilleter(8);
        if (tribuner.get(0).finnAntallSolgteBilletter() == 8) {
            System.out.println("test 1 ok");
        }

        tribuner.get(1).kjopBilleter(40);
        if (tribuner.get(1).finnAntallSolgteBilletter() == 0) {
            System.out.println("test 2 ok");
        }

        tribuner.get(2).kjopBilleter(13);
        if (tribuner.get(2).finnAntallSolgteBilletter() == 0) {
            System.out.println("test 3 ok");
        }

        if (tribuner.get(3).kjopBilleter(13) == null) {
            System.out.println("test 4 ok");
        }

        if (tribuner.get(3).kjopBilleter(new String[]{"Geir", "noob"}) != null) {
            System.out.println("test 5 ok");
        }

        if (tribuner.get(3).finnIntekt() == 760) {
            System.out.println("test 6 ok");
        }

        if (tribuner.get(3).kjopBilleter(new String[]{"Geir", "Geir", "Geir", "Geir", "Geir"}) != null &&
                tribuner.get(3).kjopBilleter(new String[]{"Geir", "Geir", "Geir", "Geir", "Geir"}) != null &&
                tribuner.get(3).kjopBilleter(new String[]{"Geir", "Geir", "Geir", "Geir", "Geir"}) == null) {
            System.out.println("test 7 ok");
        }

        if (tribuner.get(2).kjopBilleter(10) != null) {
            System.out.println("test 8 ok");
        }

        System.out.println("\nUnsorted");
        for (Tribune t: tribuner) System.out.println(t);

        Collections.sort(tribuner);

        System.out.println("Sorted");
        for (Tribune t: tribuner) System.out.println(t);


        System.out.println("\nLagrer til fil.");
        for (Tribune t: tribuner) {
            file.saveToFile(t);
        }

        System.out.println("\nLaster fra fil.");
        tribuner = new ArrayList<Tribune>();
        tribuner.add(file.loadFromFile("tribuner\\East"));

        Tribune[] tribuner2 = file.loadAllFromFile();
        for (int i = 0; i < tribuner2.length; i++) tribuner.add(tribuner2[i]);

        for (Tribune t: tribuner) System.out.println(t);
    }
}
