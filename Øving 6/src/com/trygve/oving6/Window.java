package com.trygve.oving6;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Created by Trygve on 25.01.2017.
 */
public class Window extends JFrame {
    JLabel[] textLabel = new JLabel[2];
    JList[] lists = new JList[2];
    Valuta[] valutaListe;
    int tilValuta = -1, fraValuta = -1;

    Input input = new Input();
    DecimalFormat f = new DecimalFormat("#0.00");

    public Window(Valuta[] valutaListe) {
        super("Valutakalkulator");
        this.valutaListe = valutaListe;
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        setMinimumSize(new Dimension(300, 250));
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box boxLabels = Box.createHorizontalBox();
        textLabel[0] = addLabel("Fra valuta:                       ", boxLabels);
        textLabel[1] = addLabel("Til valuta:", boxLabels);
        add(boxLabels, BorderLayout.CENTER );
        Box boxList = Box.createHorizontalBox();
        lists[0] = addList("fra", boxList);
        lists[1] = addList("til", boxList);
        add(boxList, BorderLayout.CENTER);
        setVisible(true);
    }

    private JLabel addLabel(String title, Box b) {
        JLabel label = new JLabel(title);
        b.add(label);
        return label;
    }

    private JList addList(String tilFra, Box b) {
        JList list = new JList(valutaListe);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setViewportView(list);
        if (tilFra.equals("fra")) {
            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (e.getValueIsAdjusting() == false) {
                        fraValuta = list.getSelectedIndex();
                        beregnValuta();
                    }
                }
            });
        } else {
            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (e.getValueIsAdjusting() == false) {
                        tilValuta = list.getSelectedIndex();
                        beregnValuta();
                    }
                }
            });
        }
        b.add(listScroller);
        return list;
    }

    private boolean addValuta(String valutaNavn, double valutaMotNorske, double norskeKr) {
        if (checkIfvalutaExists(valutaNavn)) return false;
        valutaListe = explandArray(valutaListe);
        valutaListe[valutaListe.length - 1] = new Valuta(valutaNavn, valutaMotNorske, norskeKr);
        return true;
    }

    private void beregnValuta() {
        if (fraValuta == 0 || tilValuta == 0) {
            String valutaNavn = input.getString("Navn på ny valuta: ");
            if (checkIfvalutaExists(valutaNavn)) {
                JOptionPane.showMessageDialog(null, valutaNavn + " eksisterer fra før.");
                return;
            }
            double kursMotNorske = input.getDouble("Valutakurs mot norske: ");
            double norskekr = input.getDouble("Og dette tilsvarer i norske kroner: ");
            if (addValuta(valutaNavn, kursMotNorske, norskekr)) {
                JOptionPane.showMessageDialog(null, f.format(valutaListe[valutaListe.length - 1].getValutaMotNorske()) + " "  + valutaListe[valutaListe.length - 1].getValutaName() +
                        " er det samme som " + f.format(valutaListe[valutaListe.length - 1].getNorskeKr()) + " norske korner.");
                lists[0].setListData(valutaListe);
                lists[1].setListData(valutaListe);
            }

            fraValuta = -1;
            tilValuta = -1;
            lists[0].clearSelection();
            lists[1].clearSelection();
        } else if (fraValuta != -1 && tilValuta != -1){
            if (fraValuta == tilValuta) {
                JOptionPane.showMessageDialog(null, "Til og fra valuta er det samme, velg en annen kombinasjon.");
            } else {
                double inputD = input.getDouble("Hvor mange " + valutaListe[fraValuta].getValutaName() + " skal du konvertere til " + valutaListe[tilValuta].getValutaName() + ".");
                JOptionPane.showMessageDialog(null, f.format(inputD) + " " + valutaListe[fraValuta].getValutaName() + " er det samme som " +
                        f.format(valutaListe[fraValuta].convertToValuta(valutaListe[tilValuta], inputD))  + " " + valutaListe[tilValuta].getValutaName() + ".");
                fraValuta = -1;
                tilValuta = -1;
                lists[0].clearSelection();
                lists[1].clearSelection();
            }
        }
    }

    private Valuta[] explandArray(Valuta[] valutaListe) {
        Valuta[] nyValutaListe = new Valuta[valutaListe.length + 1];
        for (int i = 0; i < valutaListe.length;i++) nyValutaListe[i] = valutaListe[i];
        return nyValutaListe;
    }

    private boolean checkIfvalutaExists(String valutaNavn) {
        for (int i = 0; i < valutaListe.length; i++)
            if (valutaListe[i].getValutaName().equals(valutaNavn)) return true;
        return false;
    }
}
