package com.example.jobmanage.dao;

import com.example.jobmanage.Controleurs.ConfigData;
import com.example.jobmanage.model.OffreEmploi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OffreEmploiDAO {
    public static void CreateEmploi(OffreEmploi offreEmploi) throws Exception{
        String sql ="INSERT INTO offre_emploi (titre ,description, dat_Publication )Values(?,?,?) ";
        Connection conne = ConfigData.getConnection();
        PreparedStatement pst = conne.prepareStatement(sql);
        pst.setString(1,"titre");
        pst.setString(2,"description");
        pst.setString(3,"dat_Publication");
        pst.executeUpdate();
    }

    public static List<OffreEmploi> ReadEmploi() throws Exception{
        String sql = "SELECT * FROM offre_emploi";
        Connection conne = ConfigData.getConnection();
        PreparedStatement pst = conne.prepareStatement(sql);
        List<OffreEmploi> Emploi = new ArrayList();
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            OffreEmploi offreEm = new OffreEmploi();
            offreEm .setTitre(rs.getString("titre"));
            offreEm.setDescription(rs.getString("description"));
            offreEm.setdat_publication("dat_publication");
            Emploi.add(offreEm);

        }
        return Emploi;
    }
    public static void UpdateEmploi(OffreEmploi offreEmploi) throws Exception{
        String sql = "UPDATE offre_emploi SET titre=?,description=?,dat_Publication=? WHERE id=?";
        Connection conne = ConfigData.getConnection();
        PreparedStatement pst = conne.prepareStatement(sql);
        pst.setString(1,offreEmploi.getTitre());
        pst.setString(2,offreEmploi.getDescription());
        pst.setString(3,offreEmploi.getDatePublication());
        pst.setString(4,offreEmploi.getId());
        pst.executeUpdate();
    }
    public static void DeleteEmploi(OffreEmploi offreEmploi) throws Exception{
        String sql = "DELETE FROM offre_emploi WHERE id=?";
        Connection conne = ConfigData.getConnection();
        PreparedStatement pst = conne.prepareStatement(sql);
        pst.setString(1,id);
        pst.executeUpdate();
    }

    public static void delet Emploi(OffreEmploi oddreEmploi) throws Exception

}
