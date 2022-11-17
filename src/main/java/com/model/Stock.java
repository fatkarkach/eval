package com.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Stock {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_stock", nullable = false)
    private int idStock;
    @Basic
    @Column(name = "categorie", nullable = false, length = -1)
    private String categorie;
    @Basic
    @Column(name = "produit", nullable = false, length = -1)
    private String produit;
    @Basic
    @Column(name = "prix", nullable = false)
    private int prix;
    @Basic
    @Column(name = "quantites", nullable = false)
    private int quantites;
   /* @Basic
    @Column(name = "id_users", nullable = false)
    private int idUsers;*/
    @OneToMany(mappedBy = "stockByIdStocks")
    private Collection<Promotion> promotionsByIdStock;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_users", referencedColumnName = "id_users", nullable = false)
    private Users usersByIdUsers;

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantites() {
        return quantites;
    }

    public void setQuantites(int quantites) {
        this.quantites = quantites;
    }

/*    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (idStock != stock.idStock) return false;
        if (prix != stock.prix) return false;
        if (quantites != stock.quantites) return false;
        /*if (idUsers != stock.idUsers) return false;*/
        if (categorie != null ? !categorie.equals(stock.categorie) : stock.categorie != null) return false;
        if (produit != null ? !produit.equals(stock.produit) : stock.produit != null) return false;

        return true;
    }

    public Stock(String categorie, String produit, int prix, int quantites, Users usersByIdUsers) {
        this.categorie = categorie;
        this.produit = produit;
        this.prix = prix;
        this.quantites = quantites;
        this.usersByIdUsers = usersByIdUsers;
    }

    public Stock() {
    }

    public Stock(int idStock, String categorie, String produit, int prix, int quantites, Users usersByIdUsers) {
        this.idStock = idStock;
        this.categorie = categorie;
        this.produit = produit;
        this.prix = prix;
        this.quantites = quantites;
        this.usersByIdUsers = usersByIdUsers;
    }

    @Override
    public int hashCode() {
        int result = idStock;
        result = 31 * result + (categorie != null ? categorie.hashCode() : 0);
        result = 31 * result + (produit != null ? produit.hashCode() : 0);
        result = 31 * result + prix;
        result = 31 * result + quantites;
       /* result = 31 * result + idUsers;*/
        return result;
    }

    public Collection<Promotion> getPromotionsByIdStock() {
        return promotionsByIdStock;
    }

    public void setPromotionsByIdStock(Collection<Promotion> promotionsByIdStock) {
        this.promotionsByIdStock = promotionsByIdStock;
    }

    public Users getUsersByIdUsers() {
        return usersByIdUsers;
    }

    public void setUsersByIdUsers(Users usersByIdUsers) {
        this.usersByIdUsers = usersByIdUsers;
    }
}
