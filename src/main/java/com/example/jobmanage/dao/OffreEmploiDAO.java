package com.example.jobmanage.dao;

import com.example.jobmanage.Controleurs.ConfigData;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OffreEmploiDAO {
    public void Create() throws Exception{
        String sql ="INSERT INTO offre_emploi (titre ,description, dat_Publication )Values(?,?,?) ";
        Connection conne = ConfigData.getConnection();
        PreparedStatement pst = conne.prepareStatement(sql);
        pst.setString(1,"titre");
        pst.setString(2,"description");
        pst.setString(3,"dat_Publication");
        pst.executeUpdate();
    }

}
