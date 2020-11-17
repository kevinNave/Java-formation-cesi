package cesi.fr.dao;

import cesi.fr.classes.Attaque;
import cesi.fr.classes.Dresseur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DresseurDAO implements DAO<Dresseur> {

    final static String SQL_INSERT = "INSERT INTO dresseur (nom, force) values(?, ?)";
    final static String SQL_SELECT = "SELECT id, nom, force FROM dresseur";
    final static String SQL_DELETE = "DELETE FROM dresseur WHERE id=?";
    final static String SQL_UPDATE = "UPDATE dresseur SET nom=?, prenom=? WHERE id=?";

    @Override
    public List<Dresseur> getAll() {
        // Retourne la liste des Pokémons en base
        List<Dresseur> listeDesDresseurs = new ArrayList<Dresseur>();
        try (Connection cnx = DBConnection.connect(); Statement stmt = cnx.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL_SELECT);
            while (rs.next()) {
                Dresseur dresseurCourant = new Dresseur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom")
                );
                listeDesDresseurs.add(dresseurCourant);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return listeDesDresseurs;
    }

    @Override
    public void update(Dresseur dresseur) {

    }


    @Override
    public void delete(int t) {

    }

    @Override
    public Dresseur insert(Dresseur dresseur) {
        return null;
    }

}
