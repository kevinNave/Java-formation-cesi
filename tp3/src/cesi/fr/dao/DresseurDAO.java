package cesi.fr.dao;

import cesi.fr.classes.Dresseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DresseurDAO implements DAO<Dresseur> {

    final static String SQL_INSERT = "INSERT INTO dresseur (nom, prenom) values(?, ?)";
    final static String SQL_SELECT = "SELECT id, nom, prenom FROM dresseur";
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
    public void update(Dresseur unDresseur) {
        try (Connection cnx = DBConnection.connect(); PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE)) {
            pstmt.setString(1, unDresseur.getNom());
            pstmt.setString(2, unDresseur.getPrenom());
            pstmt.setInt(3, unDresseur.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }


    @Override
    public void delete(int idDresseur) {
        try (Connection cnx = DBConnection.connect();
             PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE)
        ) {
            pstmt.setInt(1, idDresseur);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    @Override
    public Dresseur insert(Dresseur unDresseur) {
        int idGenere = 0;
        try (Connection cnx = DBConnection.connect();
             PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)
        ) {
            pstmt.setString(1, unDresseur.getNom());
            pstmt.setString(2, unDresseur.getPrenom());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idGenere = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        unDresseur.setId(idGenere);
        return unDresseur;
    }

}
