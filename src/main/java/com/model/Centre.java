package com.model;

import jakarta.persistence.*;

@Entity
public class Centre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_centre", nullable = false)
    private int idCentre;
    @Basic
    @Column(name = "nom_centre", nullable = false, length = -1)
    private String nomCentre;
    @Basic
    @Column(name = "status", nullable = false, length = -1)
    private String status;
    @Basic
    @Column(name = "ville", nullable = false, length = -1)
    private String ville;

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public String getNomCentre() {
        return nomCentre;
    }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = nomCentre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVille() {
        return ville;
    }

    public Centre(int idCentre, String nomCentre, String status, String ville) {
        this.idCentre = idCentre;
        this.nomCentre = nomCentre;
        this.status = status;
        this.ville = ville;
    }

    public Centre(String nomCentre, String status, String ville) {
        this.nomCentre = nomCentre;
        this.status = status;
        this.ville = ville;
    }

    public Centre() {
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Centre centre = (Centre) o;

        if (idCentre != centre.idCentre) return false;
        if (nomCentre != null ? !nomCentre.equals(centre.nomCentre) : centre.nomCentre != null) return false;
        if (status != null ? !status.equals(centre.status) : centre.status != null) return false;
        if (ville != null ? !ville.equals(centre.ville) : centre.ville != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCentre;
        result = 31 * result + (nomCentre != null ? nomCentre.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        return result;
    }
}
