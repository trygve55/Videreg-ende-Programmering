package com.trygve.oving4;

import java.sql.*;

public class OppgB {

    public static void main(String[] args) throws Exception{
        Input input = new Input();

        //String username = input.getString("Brukernavn: ").trim();
        //String password = input.getString("Passord: ").trim();

        String username = "trygvne";
        String password = "Ai7adJ4a";

        String databasedriver = "com.mysql.jdbc.Driver";
        Class.forName(databasedriver);

        String databaseAddress = "jdbc:mysql://mysql.stud.iie.ntnu.no:3306/" + username + "?user=" + username + "&password=" + password;

        Connection connection = DriverManager.getConnection(databaseAddress);
        Statement statement = connection.createStatement();

        String isbn, navn = "'" + input.getString("Navn: ").trim() + "'";
        int nr = input.getInt("Eksemplar nr");
        isbn =  "'" + input.getString("ISBN: ").trim() + "'";
        //isbn = input.getString("ISBN: ");
        if (0 < statement.executeUpdate("update eksemplar set laant_av = " + navn + " where isbn = " + isbn + " and eks_nr =" + nr + " and laant_av is null;")) System.out.println("Reservert.");
        else System.out.println("Kunne ikke reservere.");

        statement.close();
        connection.close();


    }
}
