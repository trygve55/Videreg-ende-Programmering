package com.trygve.oving2_Oppg1;

/**
 * Created by Trygve on 17.01.2017.
 */
public class Student {
    private final String navn;
    private int antOppg;

    public Student(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return  antOppg;
    }

    public  void  setAntOppg(int antOppg) {
        if (antOppg < 0) throw new IllegalArgumentException("Negative number not accepted");
        this.antOppg = antOppg;
    }

    public String toString() {
        return navn + " har gjort " + antOppg + " oppgaver.";
    }
}

