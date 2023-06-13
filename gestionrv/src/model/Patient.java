package model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User {

  

    @Override
    public String toString() {
        return "Patient "+super.toString()+" numero=" + numero + "]";
    }

    public Patient(String nom, String prenom, String telephone, String numero) {
        super(nom, prenom, telephone);
        this.numero = numero;
        this.role=Role.Patient;
    }

    public Patient() {
        this.role=Role.Patient;
    }

    private String numero;

    //Attributs de navigation
    List<Rv> rvs= new ArrayList<>();
      
    //Attributs de navigation
    List<Antecedant> antecedants= new ArrayList<>();
    

    public Patient(String nom, String prenom, String telephone) {
        super(nom, prenom, telephone);
        this.role=Role.Patient;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Rv> getRvs() {
        return rvs;
    }

    public void setRvs(List<Rv> rvs) {
        this.rvs = rvs;
    }

    public List<Antecedant> getAntecedants() {
        return antecedants;
    }

    public void setAntecedants(List<Antecedant> antecedants) {
        this.antecedants = antecedants;
    }
    
}
