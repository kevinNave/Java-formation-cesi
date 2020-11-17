package fr.cesi;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        // Création de la voiture
        Voiture clio = new Voiture("Renault", "Clio", 5);

        // Création des passagers
        Passager ironman = new Passager("Stark", "Anthony Edward");
        Passager thor = new Passager("Blake", "Donald");
        Passager antman = new Passager("Pym", "Henry");
        Passager laguepe = new Passager("Van Dyne", "Janet");
        Passager hulk = new Passager("Banner", "Robert Bruce");
        Passager america = new Passager("Rogers", "Steven");

        // Ajout des passagers a la voiture
        try {
            ajouterPassager(clio, ironman);
            ajouterPassager(clio, thor);
            ajouterPassager(clio, antman);
            ajouterPassager(clio, laguepe);
            ajouterPassager(clio, hulk);
            ajouterPassager(clio, america);
        }
        catch (TropDeMondeDansLaVoiture e) {
            System.err.println(e.getMessage());
        }
        // Affichage
        System.out.println(clio);
        System.out.println(clio.getListePassager());
    }

    private static void ajouterPassager(Voiture v, Passager p) throws TropDeMondeDansLaVoiture {
        if(v.getListePassager().size() < v.getNbPlaces()) {
            v.getListePassager().add(p);
        } else {
            throw new TropDeMondeDansLaVoiture("Trop de passagers");
        }
    }
}
