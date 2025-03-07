package dao;


import model.*;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobOfferDAO {
    public List<JobOffer> getAllJobOffers() {
        List<JobOffer> offers = new ArrayList<>();
        String sql = "SELECT * FROM offre_emploi";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                JobOffer offer = new JobOffer();
                offer.setId(rs.getInt("id"));
                offer.setTitre(rs.getString("titre"));
                offer.setDescription(rs.getString("description"));
                offer.setDatePublication(rs.getDate("date_publication"));
                offer.setEntreprise(rs.getString("entreprise"));
                offer.setStatut(rs.getString("statut"));
                offers.add(offer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offers;
    }

    public boolean createJobOffer(JobOffer offer) {
        String sql = "INSERT INTO offre_emploi (titre, description, date_publication, entreprise) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, offer.getTitre());
            stmt.setString(2, offer.getDescription());
            stmt.setDate(3, new java.sql.Date(offer.getDatePublication().getTime()));
            stmt.setString(4, offer.getEntreprise());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
