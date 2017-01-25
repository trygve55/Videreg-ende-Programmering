package com.trygve.oving2_Oppg1;

/**
 * Created by Trygve on 17.01.2017.
 */
public class OppgaveOversikt {
    private Student[] studenter = new Student[0];
    private int antStud = 0;

    public int finnAntStud() {
        return  antStud;
    }

    public int finnAntOppgaver(String navn) {
        for (int i = 0; i < studenter.length; i++) if (studenter[i] != null && navn.equals(studenter[i].getNavn())) return studenter[i].getAntOppg();
        return -1;
    }

    public boolean økAntOppg(String navn, int tasks) {
        for (int i = 0; i < studenter.length; i++) {
            if (navn.equals(studenter[i].getNavn())) {
                if (studenter[i].getAntOppg() + tasks < 0) return false;
                studenter[i].setAntOppg(studenter[i].getAntOppg() + tasks);
                return true;
            }
        }
        return false;
    }

    public String[] finnAlleNavn() {
        String[] navn = new String[0];
        for (int i = 0;i < studenter.length;i++) {
            if (studenter[i] != null) {
                navn = expandArray(navn);
                navn[navn.length - 1] = studenter[i].getNavn();
            }
        }
        return navn;
    }

    public boolean regNyStudent(String name) {
        if (finnAntOppgaver(name) != -1) return false;

        if (studenter.length == 0 || studenter[studenter.length - 1] != null) studenter = expandArray(studenter);

        for (int i = 0; i < studenter.length; i++) {
            if (studenter[i] == null) {
                studenter[i] = new Student(name);
                antStud++;
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String returnString = "";
        for (int i = 0; i < studenter.length; i++) returnString += studenter[i].toString();
        return returnString;
    }

    private Student[] expandArray(Student[] oldArray) {
        Student[] newArray = new Student[oldArray.length + 1];

        for (int i = 0; i < oldArray.length; i++) newArray[i] = oldArray[i];

        return newArray;
    }

    private String[] expandArray(String[] oldArray) {
        String[] newArray = new String[oldArray.length + 1];

        for (int i = 0; i < oldArray.length; i++) newArray[i] = oldArray[i];

        return newArray;
    }
}
