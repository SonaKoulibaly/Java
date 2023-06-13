package model;

import java.sql.Date;

public class Rv {

    public Rv(Date date, String heuredb, String heurefin, Medecin medecin, Patient patient) {
        this.date = date;
        this.heuredb = heuredb;
        this.heurefin = heurefin;
        this.medecin = medecin;
        this.patient = patient;
        this.statut= Statut.Pasvalider;
    }
    @Override
    public String toString() {
        return "Rv [id=" + id + ", numero=" + numero + ", date=" + date + ", heuredb=" + heuredb + ", heurefin="
                + heurefin + ", statut=" + statut + ", medecin=" + medecin + ", patient=" + patient + "]";
    }
    public Rv(String numero, Date date, String heuredb, String heurefin, Medecin medecin, Patient patient) {
        this.numero = numero;
        this.date = date;
        this.heuredb = heuredb;
        this.heurefin = heurefin;
        this.medecin = medecin;
        this.patient = patient;
        this.statut= Statut.Pasvalider;
    }
    public Rv() {
        this.statut=Statut.Pasvalider;
    }
    private int id;
    private String numero;
    private Date date;
    private  String heuredb;
    private  String heurefin;
    private Statut statut;

     //Attributs de navigation
     private Medecin medecin;
     private Patient patient;

     
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getHeuredb() {
        return heuredb;
    }
    public void setHeuredb(String heuredb) {
        this.heuredb = heuredb;
    }
    public String getHeurefin() {
        return heurefin;
    }
    public void setHeurefin(String heurefin) {
        this.heurefin = heurefin;
    }
    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    public Medecin getMedecin() {
        return medecin;
    }
    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }






}
