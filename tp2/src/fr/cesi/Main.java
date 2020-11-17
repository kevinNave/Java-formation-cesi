package fr.cesi;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String jdbc = "jdbc:sqlite:D:\\Java\\tp2\\src\\fr\\cesi\\database";

        // Créer une connexion + Créer un état + Tester et valider la connexion
        try { Connection cnx = DriverManager.getConnection(jdbc);
             Statement stmt = cnx.createStatement();
            //Exécuter la requête
            String sql = "SELECT marque, modele, nbPlaces FROM voiture";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("marque"));
                System.out.println(rs.getString("modele"));
                System.out.println(rs.getString("nbPlaces"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }
}
