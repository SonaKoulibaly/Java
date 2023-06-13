package model;

import java.util.ArrayList;
import java.util.List;

public class Specialiste {

    @Override
    public String toString() {
        return "Specialiste [id=" + id + ", libelle=" + libelle + "]";
    }

    public Specialiste(String libelle) {
        this.libelle = libelle;
    }

    public Specialiste() {
    }

    private int id;
    private String libelle;

    ////Attributs de navigation
    List<Medecin> medecins= new ArrayList<>();
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }
    
}
