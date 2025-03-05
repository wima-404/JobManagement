package com.example.jobmanage.Controleurs;

import com.example.jobmanage.dao.OffreEmploiDAO;
import com.example.jobmanage.model.OffreEmploi;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class OffreEmploiServlet {

    OffreEmploiDAO offreEmploiDAO = new OffreEmploiDAO();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String action = request.getParameter("action");
  if("create".equals(action)){
      OffreEmploi emploi = new OffreEmploi();
      emploi.setTitre(request.getParameter("titre"));
      emploi.setDescription(request.getParameter("description"));
      emploi.setDatePublication(request.getParameter("datePublication"));
  }
  }
}
