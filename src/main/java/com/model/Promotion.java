package com.model;

import jakarta.persistence.*;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_promo", nullable = false)
    private int idPromo;
    @Basic
    @Column(name = "promo", nullable = false)
    private int promo;
    @Basic
    @Column(name = "points", nullable = false)
    private int points;
 /*   @Basic
    @Column(name = "id_stocks", nullable = false)
    private int idStocks;*/
    @Basic
    @Column(name = "disponible", nullable = false, length = -1)
    private String disponible;
    @Basic
    @Column(name = "date_expiration", nullable = false, length = -1)
    private String dateExpiration;
  /*  @Basic
    @Column(name = "id_users", nullable = false)
    private int idUsers;*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_stocks", referencedColumnName = "id_stock", nullable = false)
    private Stock stockByIdStocks;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_users", referencedColumnName = "id_users", nullable = false)
    private Users usersByIdUsers;

    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

  /*  public int getIdStocks() {
        return idStocks;
    }

    public void setIdStocks(int idStocks) {
        this.idStocks = idStocks;
    }*/

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Promotion(int promo, int points, String disponible, String dateExpiration, Stock stockByIdStocks, Users usersByIdUsers) {
        this.promo = promo;
        this.points = points;
        this.disponible = disponible;
        this.dateExpiration = dateExpiration;
        this.stockByIdStocks = stockByIdStocks;
        this.usersByIdUsers = usersByIdUsers;
    }

    public Promotion() {
    }

    public Promotion(int idPromo, int promo, int points, String disponible, String dateExpiration, Stock stockByIdStocks, Users usersByIdUsers) {
        this.idPromo = idPromo;
        this.promo = promo;
        this.points = points;
        this.disponible = disponible;
        this.dateExpiration = dateExpiration;
        this.stockByIdStocks = stockByIdStocks;
        this.usersByIdUsers = usersByIdUsers;
    }

  /*  public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (idPromo != promotion.idPromo) return false;
        if (promo != promotion.promo) return false;
        if (points != promotion.points) return false;
     /*   if (idStocks != promotion.idStocks) return false;
        if (idUsers != promotion.idUsers) return false;*/
        if (disponible != null ? !disponible.equals(promotion.disponible) : promotion.disponible != null) return false;
        if (dateExpiration != null ? !dateExpiration.equals(promotion.dateExpiration) : promotion.dateExpiration != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPromo;
        result = 31 * result + promo;
        result = 31 * result + points;
        /*result = 31 * result + idStocks;*/
        result = 31 * result + (disponible != null ? disponible.hashCode() : 0);
        result = 31 * result + (dateExpiration != null ? dateExpiration.hashCode() : 0);
        /*result = 31 * result + idUsers;*/
        return result;
    }

    public Stock getStockByIdStocks() {
        return stockByIdStocks;
    }

    public void setStockByIdStocks(Stock stockByIdStocks) {
        this.stockByIdStocks = stockByIdStocks;
    }

    public Users getUsersByIdUsers() {
        return usersByIdUsers;
    }

    public void setUsersByIdUsers(Users usersByIdUsers) {
        this.usersByIdUsers = usersByIdUsers;
    }
}
