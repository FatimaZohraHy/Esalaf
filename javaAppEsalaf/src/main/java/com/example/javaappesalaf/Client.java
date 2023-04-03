package com.example.javaappesalaf;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String tel;
    private int credit;



    public Client(int id, String nom, String prenom, String tel, int x) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.credit=x;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
