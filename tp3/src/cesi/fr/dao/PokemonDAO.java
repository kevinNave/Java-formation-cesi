package cesi.fr.dao;

import cesi.fr.classes.Attaque;
import cesi.fr.classes.Dresseur;
import cesi.fr.classes.Pokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO implements DAO<Pokemon> {

    final static String SQL_INSERT = "INSERT INTO pokemon (id, nom, poids, taille, design, attaque01, attaque02, dresseur_id) values(?, ?, ?, ?, ?, ?, ?, ?)"; //REVOIR REQUETE
    final static String SQL_SELECT = "SELECT * FROM pokemon";
    final static String SQL_SELECT_BY_ID = "SELECT * FROM pokemon WHERE nom = ?";
    final static String SQL_DELETE = "DELETE FROM pokemon WHERE nom=?";
    final static String SQL_UPDATE = "UPDATE pokemon SET attaque01=?, attaque02=? WHERE nom=?";

    public Pokemon getByNom(String unNomPokemon) {
        AttaqueDAO adao = new AttaqueDAO();
        DresseurDAO ddao = new DresseurDAO();
        Pokemon p = new Pokemon();
        try (Connection cnx = DBConnection.connect(); PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID)) {
            pstmt.setString(1, unNomPokemon);
            ResultSet rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    p.setId(rs.getInt("id"));
                    p.setNom(rs.getString("nom"));
                    p.setPoids(rs.getFloat("poids"));
                    p.setTaille(rs.getFloat("taille"));
                    p.setDesign(rs.getString("design"));
                    p.setAttaque01(adao.getAll().get(rs.getInt("attaque01")));
                    p.setAttaque02(adao.getAll().get(rs.getInt("attaque02")));
                    p.setDresseur(ddao.getAll().get(rs.getInt("dresseur_id")));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return p;
    }

    @Override
    public List getAll() {
        List<Pokemon> listeDesPokemons = new ArrayList<Pokemon>();
        AttaqueDAO adao = new AttaqueDAO();
        DresseurDAO ddao = new DresseurDAO();
        try (Connection cnx = DBConnection.connect(); Statement stmt = cnx.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL_SELECT);
                while (rs.next()) {
                    Attaque atq01 = adao.getAll().get(rs.getInt("attaque01"));
                    Attaque atq02 = adao.getAll().get(rs.getInt("attaque02"));
                    Dresseur unDresseur = ddao.getAll().get(rs.getInt("dresseur_id"));
                    Pokemon pokemonCourant = new Pokemon(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getFloat("poids"),
                            rs.getFloat("taille"),
                            rs.getString("design"),
                            atq01,
                            atq02,
                            unDresseur
                    );
                    listeDesPokemons.add(pokemonCourant);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return listeDesPokemons;
    }

    @Override
    public void update(Pokemon unPokemon) {
        try (Connection cnx = DBConnection.connect(); PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE)) {
            pstmt.setString(1, unPokemon.getAttaque01().getNom());
            pstmt.setString(2, unPokemon.getAttaque02().getNom());
            pstmt.setString(3, unPokemon.getNom());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    @Override
    public void delete(int idPokemon) {
        try (Connection cnx = DBConnection.connect();
             PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE)
        ) {
            pstmt.setInt(1, idPokemon);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    @Override
    public Pokemon insert(Pokemon unPokemon) {
        int idGenere = 0;
        try (Connection cnx = DBConnection.connect();
             PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS) //recup l'id unique
        ) {
            pstmt.setInt(1, unPokemon.getId());
            pstmt.setString(2, unPokemon.getNom());
            pstmt.setFloat(3, unPokemon.getPoids());
            pstmt.setFloat(4, unPokemon.getTaille());
            pstmt.setString(5, unPokemon.getDesign());
            pstmt.setInt(6, unPokemon.getAttaque01().getId());
            pstmt.setInt(7, unPokemon.getAttaque02().getId());
            pstmt.setInt(8, unPokemon.getDresseur().getId());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idGenere = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        unPokemon.setId(idGenere);
        return unPokemon;
    }
}

