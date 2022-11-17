package com.model;

import jakarta.persistence.*;

@Entity
public class Responsable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_respo", nullable = false)
    private int idRespo;
    @Basic
    @Column(name = "nom", nullable = false, length = -1)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = -1)
    private String prenom;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
   /* @Basic
    @Column(name = "id_users", nullable = false)
    private int idUsers;*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_users", referencedColumnName = "id_users", nullable = false)
    private Users usersByIdUsers;

    public int getIdRespo() {
        return idRespo;
    }

    public void setIdRespo(int idRespo) {
        this.idRespo = idRespo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

        Responsable that = (Responsable) o;

        if (idRespo != that.idRespo) return false;
       /* if (idUsers != that.idUsers) return false;*/
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    public Responsable(String nom, String prenom, String email, String password, Users usersByIdUsers) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.usersByIdUsers = usersByIdUsers;
    }

    public Responsable() {
    }

    public Responsable(int idRespo, String nom, String prenom, String email, String password, Users usersByIdUsers) {
        this.idRespo = idRespo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.usersByIdUsers = usersByIdUsers;
    }

    @Override
    public int hashCode() {
        int result = idRespo;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
       /* result = 31 * result + idUsers;*/
        return result;
    }

    public Users getUsersByIdUsers() {
        return usersByIdUsers;
    }

    public void setUsersByIdUsers(Users usersByIdUsers) {
        this.usersByIdUsers = usersByIdUsers;
    }
}
