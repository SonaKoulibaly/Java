package model;

public class User {

    @Override
    public String toString() {
        return " [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", role=" + role
                ;
    }
    public User(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }
    public User() {
    }
    protected int id;
    protected String nom;
    protected String prenom;
    protected String telephone;
    protected Role role;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    
     



}
