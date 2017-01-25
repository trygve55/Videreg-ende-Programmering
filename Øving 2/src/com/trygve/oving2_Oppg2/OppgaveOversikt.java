package oving2_Oppg2;

import java.util.ArrayList;

/**
 * Created by Trygve on 17.01.2017.
 */
public class OppgaveOversikt {
    private ArrayList<Student> studenter = new ArrayList<Student>();
    private int antStud = 0;

    public int finnAntStud() {
        return  studenter.size();
    }

    public int finnAntOppgaver(String navn) {

        for (int i = 0;i < studenter.size();i++) if (studenter.get(i).getNavn().equals(navn)) return studenter.get(i).getAntOppg();

        return -1;
    }

    public boolean økAntOppg(String navn, int tasks) {

        for (int i = 0;i < studenter.size();i++) {
            if (studenter.get(i).getNavn().equals(navn)) {
                if (studenter.get(i).getAntOppg() + tasks < 0) return false;
                studenter.get(i).setAntOppg(studenter.get(i).getAntOppg() + tasks);
                return true;
            }
        }
        return false;
    }

    public String[] finnAlleNavn() {
        String[] navn = new String[0];
        for (int i = 0;i < studenter.size();i++) {
            navn = expandArray(navn);
            navn[navn.length - 1] = studenter.get(i).getNavn();
        }
        return navn;
    }

    public boolean regNyStudent(String navn) {

        studenter.add(new Student(navn));

        return true;
    }

    public String toString() {
        String returnString = "";
        for (int i = 0;i < studenter.size();i++) returnString += studenter.get(i).toString() + "\n";
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
