package oving2_Oppg2;

/**
 * Created by Trygve on 18.01.2017.
 */
public class testClass {
    public static void main(String[] args) {
        OppgaveOversikt oppgaveOversikt = new OppgaveOversikt();

        oppgaveOversikt.regNyStudent("geir");

        System.out.println(oppgaveOversikt.finnAntStud());

        System.out.println(oppgaveOversikt.finnAntOppgaver("geir"));
    }
}
