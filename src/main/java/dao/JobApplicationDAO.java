package dao;

import model.JobApplication;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobApplicationDAO {
    public List<JobApplication> getApplicationsByJobOffer(int jobOfferId) {
        List<JobApplication> applications = new ArrayList<>();
        String sql = "SELECT * FROM candidature WHERE offre_emploi_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, jobOfferId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    JobApplication application = new JobApplication();
                    application.setId(rs.getInt("id"));
                    application.setOffreEmploiId(rs.getInt("offre_emploi_id"));
                    application.setCandidatId(rs.getInt("candidat_id"));
                    application.setDateCandidature(rs.getTimestamp("date_candidature"));
                    application.setStatut(rs.getString("statut"));
                    application.setLettreMutation(rs.getString("lettre_motivation"));
                    applications.add(application);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    public boolean applyToJobOffer(JobApplication application) {
        String sql = "INSERT INTO candidature (offre_emploi_id, candidat_id, lettre_motivation) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, application.getOffreEmploiId());
            stmt.setInt(2, application.getCandidatId());
            stmt.setString(3, application.getLettreMutation());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}