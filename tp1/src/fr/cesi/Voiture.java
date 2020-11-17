package fr.cesi;

import java.util.ArrayList;
import java.util.List;

public class Voiture {

    String marque;
    String modele;
    int nbPlaces;
    List<Passager> listePassager;

    public Voiture(String marque, String modele, int nbPlaces) {
        this.marque = marque;
        this.modele = modele;
        this.nbPlaces = nbPlaces;
        this.listePassager = new ArrayList<>();
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public List<Passager> getListePassager() {
        return listePassager;
    }

    public void setListePassager(List<Passager> listePassager) {
        this.listePassager = listePassager;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", nbPlaces=" + nbPlaces +
                '}';
    }
}
