package cesi.fr.dao;

import cesi.fr.classes.Pokemon;

import java.util.List;

public class PokemonDAO implements DAO<Pokemon> {

    final static String SQL_INSERT = "INSERT INTO pokemon (id, nom, poids, taille, design, attaque01, attaque02, dresseur_id) values(?, ?, ?, ?, ?, ?, ?, ?)"; //REVOIR REQUETE
    final static String SQL_SELECT = "SELECT * FROM pokemon";
    final static String SQL_DELETE = "DELETE FROM pokemon WHERE nom=?";
    final static String SQL_UPDATE = "UPDATE pokemon SET attaque01=?, attaque02=? WHERE nom=?";

    public Pokemon getByNom(String unNomPokemon) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void update(Pokemon unPokemon) {

    }

    @Override
    public void delete(int idPokemon) {

    }

    @Override
    public Pokemon insert(Pokemon unPokemon) {
        return null;
    }
}
