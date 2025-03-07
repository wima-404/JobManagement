package model;


import java.util.Date;

public class JobOffer {
    private int id;
    private String titre;
    private String description;
    private Date datePublication;
    private String entreprise;
    private String statut;

    // Constructor
    public JobOffer() {}

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Date getDatePublication() { return datePublication; }
    public void setDatePublication(Date datePublication) { this.datePublication = datePublication; }
    public String getEntreprise() { return entreprise; }
    public void setEntreprise(String entreprise) { this.entreprise = entreprise; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}