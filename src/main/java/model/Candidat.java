package model;

import java.util.Date;

public class Candidat {
    private int idCandidat;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String cv;
    private Date dateInscription;

    // Constructeurs
    public Candidat() {}

    public Candidat(int idCandidat, String nom, String prenom, String email, String motDePasse, String cv, Date dateInscription) {
        this.idCandidat = idCandidat;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.cv = cv;
        this.dateInscription = dateInscription;
    }

    // Getters et Setters
    public int getIdCandidat() { return idCandidat; }
    public void setIdCandidat(int idCandidat) { this.idCandidat = idCandidat; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getCv() { return cv; }
    public void setCv(String cv) { this.cv = cv; }

    public Date getDateInscription() { return dateInscription; }
    public void setDateInscription(Date dateInscription) { this.dateInscription = dateInscription; }
}