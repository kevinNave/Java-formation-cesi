package cesi.fr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connect() {
        String jdbc = "jdbc:sqlite:D:\\Java\\tp3\\src\\cesi\\fr\\db.sqlite3";
        Connection cnx = null;
        try {
            cnx = DriverManager.getConnection(jdbc);
        }
        catch (SQLException e) {
            System.err.println("Erreur SQL");
        }
        return cnx;
    }
}
