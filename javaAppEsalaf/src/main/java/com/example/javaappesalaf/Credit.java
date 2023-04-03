package com.example.javaappesalaf;

import java.util.ArrayList;
import java.util.List;

public class Credit {

    private int x;
    private String date;
    List<Client> client;
    List<Produits> produits;

    public Credit(int x, String date, ArrayList<Client> client, ArrayList<Produits> produits) {
        this.x = x;
        this.date = date;
        this.client = client;
        this.produits = produits;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public List<Produits> getProduits() {
        return produits;
    }

    public void setProduits(List<Produits> produits) {
        this.produits = produits;
    }
}
