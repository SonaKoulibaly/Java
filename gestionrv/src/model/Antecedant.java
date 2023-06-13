package model;

import java.util.ArrayList;
import java.util.List;

public class Antecedant {

    public Antecedant(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Antecedant [id=" + id + ", libelle=" + libelle + "]";
    }

    public Antecedant() {
    }

    private int id;
    private String libelle;
    
    //Attributs de navigation
    List<Patient> patients= new ArrayList<>();
    

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

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    
}
