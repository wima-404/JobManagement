package com.example.jobmanage.model;

public class OffreEmploi {
    String id;
    String titre;
    String description;
    String dat_Publication;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDat_Publication() {
        return dat_Publication;
    }

    public void setDat_Publication(String dat_Publication) {
        this.dat_Publication = dat_Publication;
    }

    public OffreEmploi(String id, String titre, String description, String dat_Publication) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dat_Publication = dat_Publication;


    }
}
