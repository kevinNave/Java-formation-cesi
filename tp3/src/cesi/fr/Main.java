package cesi.fr;

import cesi.fr.classes.Attaque;
import cesi.fr.classes.Dresseur;
import cesi.fr.classes.Pokemon;
import cesi.fr.dao.AttaqueDAO;
import cesi.fr.dao.DresseurDAO;
import cesi.fr.dao.PokemonDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*AttaqueDAO adao = new AttaqueDAO();
        Attaque uneAttaque = new Attaque(3, "Tonnerre", 25);
        adao.update(uneAttaque);
        List<Attaque> lst = adao.getAll();
        System.out.println(lst);*/

        /*DresseurDAO ddao = new DresseurDAO();
        Dresseur unDresseur = new Dresseur("Savary", "Clement");
        //ddao.insert(unDresseur);
        List<Dresseur> lstD = ddao.getAll();
        System.out.println(lstD);*/

        PokemonDAO pdao = new PokemonDAO();
        //Pokemon pkm = pdao.getByNom("Raichu");
       List<Pokemon> lstP = pdao.getAll();
        System.out.println(pdao.getByNom("Raichu"));
        System.out.println(lstP);
    }
}



