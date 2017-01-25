package com.trygve.oving6;

import javax.swing.*;

/**
 * Created by Trygve on 25.01.2017.
 */
public class Input {
    public String getString(String dialog) {
        return JOptionPane.showInputDialog(dialog).trim();
    }

    public String getString(String dialog, int minimumLength) {
        if (minimumLength < 0) throw new IllegalArgumentException("minimum length can't be a negative number");
        String input;
        do {
            input = getString(dialog);
        } while (input.length() >= minimumLength);
        return input;
    }

    public double getDouble(String dialog) {
        double input = 0.0;
        boolean exit = false;
        do {
            try {
                exit = true;
                input = Double.parseDouble(JOptionPane.showInputDialog(dialog));
            } catch (Exception e) {
                exit = false;
            }
        } while (!exit);

        return input;
    }
}
