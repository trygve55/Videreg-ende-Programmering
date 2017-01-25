package com.trygve.oving5oppg2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by Trygve on 25.01.2017.
 */
public class Window extends JFrame {
    JButton[] buttons = new JButton[2];
    JLabel[] textLabel = new JLabel[3];
    Font currentFont;
    TextField textField;
    double fraNorskTilSvensk = 1.06021524;
    Window() {
        super("Font test");
        setLayout(new GridLayout(3, 2, 10, 10));
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textLabel[0] = addLabel("Beløp:");
        textField = new TextField(10);
        add(textField);
        textLabel[1] = addLabel("Konvertert Beløp: ");
        textLabel[2] = addLabel("N/A");
        buttons[0] = addButton("Til svensk");
        buttons[1] = addButton("Til norsk");

        setVisible(true);

    }

    private void updateLabels() {

        revalidate();
        repaint();
    }

    private JButton addButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DecimalFormat formatter = new DecimalFormat("#0.00");
                try {
                    if (text.contains("svensk"))
                        textLabel[2].setText(formatter.format(fraNorskTilSvensk * Double.parseDouble(textField.getText())) + " sek");
                    if (text.contains("norsk"))
                        textLabel[2].setText(formatter.format(Double.parseDouble(textField.getText()) / fraNorskTilSvensk) + " nok");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Feil i input(ikke et tall)");
                }
                updateLabels();
            }
        });
        add(button);
        return button;
    }

    private JLabel addLabel(String title) {
        JLabel label = new JLabel(title);
        add(label);
        return label;
    }
}
