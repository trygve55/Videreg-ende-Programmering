package com.trygve.oving4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OppgA {

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

        String isbn, forfatter, tittel;

        /*ResultSet res = statement.executeQuery("select * from boktittel");
        while (res.next()) {
            isbn = res.getString("isbn");
            forfatter = res.getString("forfatter");
            tittel = res.getString("tittel");
            System.out.println(isbn + " " + forfatter + " " + tittel);
        }
        res.close();*/
        boolean exit;

        isbn = "0-07-241163-5";
        //isbn = input.getString("ISBN: ");
        ResultSet res = statement.executeQuery("select forfatter, tittel from boktittel where isbn = '" + isbn + "';");
        while (res.next()) {
            forfatter = res.getString("forfatter");
            tittel = res.getString("tittel");
            System.out.println(isbn + " " + forfatter + " " + tittel);
        }
        res.close();

        res = statement.executeQuery("select count(*) antall from eksemplar where isbn = '" + isbn + "';");
        while (res.next()) {
            System.out.println("Antall eksemplarer: " + res.getInt("antall"));
        }
        res.close();

        res.close();
        statement.close();
        connection.close();


    }
}
