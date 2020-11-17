package fr.cesi.dao;

import java.sql.*;

public class pokemonCRUD {

    String jdbc = "jdbc:sqlite:D:\\Java\\tp2\\src\\fr\\cesi\\database";


    public void pokemonInsert() {
        // Créer une connexion + Créer un état + Tester et valider la connexion
      /*  try {

            Connection cnx = DriverManager.getConnection(jdbc);
            Statement stmt = cnx.createStatement() {

                String sql = "INSERT INTO pokemon (id, nom, poids, taille, design, attaque01_id, attaque02_id, dresseur_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement statement = cnx.prepareStatement(sql);
                statement.setInt(1, 6);
                statement.setString(2, "Raichu");
                statement.setFloat(3, 1.2);
                statement.setFloat(4, 0.8);
                statement.setString(5, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png");
                statement.setInt(6, 1);
                statement.setInt(7, 2);
                statement.setInt(8, 2);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Pokémon Ajouté");
                }
            }

        } catch (
                SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }*/
    }
    /*Avoir la liste des pokémon*/
    public void pokemonRead(Statement stmt) {
        try {
            //Exécuter la requête
            String sql = "SELECT * FROM pokemon";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nom"));
                System.out.println(rs.getFloat("poids"));
                System.out.println(rs.getFloat("taille"));
                System.out.println(rs.getString("design"));
                System.out.println(rs.getInt("attaque01_id"));
                System.out.println(rs.getInt("attaque02_id"));
                System.out.println(rs.getInt("dresseur_id"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

}


