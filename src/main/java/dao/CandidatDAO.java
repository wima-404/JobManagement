package dao;
import java.util.ArrayList; // Ajoutez cette ligne
import java.util.List;      // Déjà présent, mais assurez-vous qu'il est là
import model.Candidat;

import java.sql.*;

public class CandidatDAO {
    private Connection connection;

    public CandidatDAO() {
        this.connection = connection;
    }

    // Ajouter un candidat
    public boolean ajouterCandidat(Candidat candidat) {
        String sql = "INSERT INTO Candidat (nom, prenom, email, motDePasse, cv, dateInscription) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, candidat.getNom());
            statement.setString(2, candidat.getPrenom());
            statement.setString(3, candidat.getEmail());
            statement.setString(4, candidat.getMotDePasse());
            statement.setString(5, candidat.getCv());
            statement.setDate(6, new java.sql.Date(candidat.getDateInscription().getTime()));
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Modifier un candidat
    public boolean modifierCandidat(Candidat candidat) {
        String sql = "UPDATE Candidat SET nom=?, prenom=?, email=?, motDePasse=?, cv=?, dateInscription=? WHERE idCandidat=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, candidat.getNom());
            statement.setString(2, candidat.getPrenom());
            statement.setString(3, candidat.getEmail());
            statement.setString(4, candidat.getMotDePasse());
            statement.setString(5, candidat.getCv());
            statement.setDate(6, new java.sql.Date(candidat.getDateInscription().getTime()));
            statement.setInt(7, candidat.getIdCandidat());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Supprimer un candidat
    public boolean supprimerCandidat(int idCandidat) {
        String sql = "DELETE FROM Candidat WHERE idCandidat=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCandidat);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Afficher tous les candidats
    public List<Candidat> afficherCandidats() {
        List<Candidat> candidats = new ArrayList<>();
        String sql = "SELECT * FROM Candidat";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Candidat candidat = new Candidat();
                candidat.setIdCandidat(resultSet.getInt("idCandidat"));
                candidat.setNom(resultSet.getString("nom"));
                candidat.setPrenom(resultSet.getString("prenom"));
                candidat.setEmail(resultSet.getString("email"));
                candidat.setMotDePasse(resultSet.getString("motDePasse"));
                candidat.setCv(resultSet.getString("cv"));
                candidat.setDateInscription(resultSet.getDate("dateInscription"));
                candidats.add(candidat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidats;
    }
}