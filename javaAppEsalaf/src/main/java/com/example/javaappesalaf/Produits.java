package com.example.javaappesalaf;

public class Produits {
    private int id;
    private int prix;
    private String nom;

    public Produits(int id, String nom,int prix) {
        this.id = id;
        this.prix = prix;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Produits{" +
                "prix=" + prix +
                ", nom='" + nom + '\'' +
                '}';
    }
}
