package com.trygve.oving4;

/**
 * Created by Trygve on 19.01.2017.
 */
import java.util.Scanner;

class Input {

    public int getInt(String dialog, int minimum, int maximum) {
        int i = minimum - 1;

        do {
            try {
                i = getInt(dialog);
            } catch (Exception e) {}
        } while (i < minimum || i > maximum);

        return i;
    }

    public long getLong(String dialog, long minimum, long maximum) {
        long i = minimum - 1;

        do {
            try {
                i = getLong(dialog);
            } catch (Exception e) {}
        } while (i < minimum || i > maximum);

        return i;
    }

    public int getInt(String dialog) {

        System.out.println(dialog);
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }

    public long getLong(String dialog) {

        System.out.println(dialog);
        Scanner sc = new Scanner(System.in);

        return sc.nextLong();
    }

    public String getString(String dialog) {

        String inputString = "";
        System.out.println(dialog);
        do {
            Scanner sc = new Scanner(System.in);
            inputString = sc.nextLine();
        } while (inputString.trim().length() == 0);

        return inputString;
    }
}
