package sn.isi.entité;

import java.io.Serializable;

public class Produit implements Serializable {

    private int id;
    private String ref;
    private String nom;
    private User user;
    // constructeurs


    public Produit(int id, String ref, String nom, User user) {
        this.id = id;
        this.ref = ref;
        this.nom = nom;
        this.user = user;
    }

    public Produit() {
    super();
    }
    //getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


