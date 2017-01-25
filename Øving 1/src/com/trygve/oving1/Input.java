package com.trygve.oving1;

import java.util.Scanner;

class Input {
    public Input() {}

    public int getInt(String dialog) {

        int inputTall = 0;
        boolean noExit = true;

        while (noExit) {
            noExit = false;
            System.out.println(dialog);
            Scanner sc = new Scanner(System.in);

            try {
                inputTall = sc.nextInt();
            } catch (Exception e) {
                noExit = true;
                throw new IllegalArgumentException("not valid int");
            }
        }
        return inputTall;
    }

    public String getString(String dialog) {

        String inputString = "";
        System.out.println(dialog);
        Scanner sc = new Scanner(System.in);
        inputString = sc.nextLine();

        return inputString;
    }
}