package model;

import java.util.Date;

public class JobApplication {
    private int id;
    private int offreEmploiId;
    private int candidatId;
    private Date dateCandidature;
    private String statut;
    private String lettreMutation;

    // Constructor
    public JobApplication() {}

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getOffreEmploiId() { return offreEmploiId; }
    public void setOffreEmploiId(int offreEmploiId) { this.offreEmploiId = offreEmploiId; }
    public int getCandidatId() { return candidatId; }
    public void setCandidatId(int candidatId) { this.candidatId = candidatId; }
    public Date getDateCandidature() { return dateCandidature; }
    public void setDateCandidature(Date dateCandidature) { this.dateCandidature = dateCandidature; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public String getLettreMutation() { return lettreMutation; }
    public void setLettreMutation(String lettreMutation) { this.lettreMutation = lettreMutation; }
}