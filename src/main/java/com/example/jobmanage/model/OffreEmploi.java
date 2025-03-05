package com.example.jobmanage.model;

public class OffreEmploi {
    String titre;
    String Description;
    String DatePublication;

    public OffreEmploi(String titre, String description, String datePublication) {
        this.titre = titre;
        Description = description;
        DatePublication = datePublication;
    }

    public OffreEmploi() {

    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDatePublication() {
        return DatePublication;
    }

    public void setDatePublication(String datePublication) {
        DatePublication = datePublication;
    }
}
