package model;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends User {

    
    @Override
    public String toString() {
        return "Medecin "+super.toString()+" nci=" + nci + "]";

    }
    public Medecin(String nom, String prenom, String telephone, String nci) {
        super(nom, prenom, telephone);
        this.nci = nci;
        this.role=Role.Medecin;
    }
    public Medecin() {
        this.role=Role.Medecin;
    }
    private String nci;

    ////Attributs de navigation
    List<Rv> rvs= new ArrayList<>();

    
    private Specialiste specialiste;
    public String getNci() {
        return nci;
    }
    public void setNci(String nci) {
        this.nci = nci;
    }
    public List<Rv> getRvs() {
            return rvs;
    }
    public void setRvs(List<Rv> rvs) {
        this.rvs = rvs;
    }
    public Specialiste getSpecialiste() {
        return specialiste;
    }
    public void setSpecialiste(Specialiste specialiste) {
        this.specialiste = specialiste;
    }

    
}
