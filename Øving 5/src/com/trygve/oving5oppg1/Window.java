package com.trygve.oving5oppg1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trygve on 25.01.2017.
 */
public class Window extends JFrame {
    JButton[] buttons = new JButton[4];
    JLabel textLabel;
    Font currentFont;
    Window() {
        super("Font test");
        setLayout(new GridLayout(1, 5, 10, 10));
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textLabel = addLabel("font");
        buttons[0] = addButton("SansSerif");
        buttons[1] = addButton("Serif");
        buttons[2] = addButton("Monospaced");
        buttons[3] = addButton("Dialog");

        setVisible(true);

    }

    private void updateLabels() {
        textLabel.setFont(currentFont);
        textLabel.setText(currentFont.getFontName());
        revalidate();
        repaint();
    }

    private JButton addButton(String fontType) {
        JButton button = new JButton(fontType);
        button.setFont(new Font(fontType, Font.PLAIN, 12));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFont = new Font(fontType, Font.PLAIN, 12);
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
