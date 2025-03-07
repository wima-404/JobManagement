package com.example.jobmanage.Controleurs;

import com.example.jobmanage.dao.OffreEmploiDAO;
import com.example.jobmanage.model.OffreEmploi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/offre")
public class OffreEmploiServlet extends HttpServlet {

    private OffreEmploiDAO offreEmploiDAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Offre.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String titre = request.getParameter("titre");
            String description = request.getParameter("description");


            OffreEmploi offre = new OffreEmploi();
            offre.setTitre(titre);
            offre.setDescription(description);
            Date sqlDate = new Date(new java.util.Date().getTime());
            offre.setDatePublication(String.valueOf(sqlDate));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = sdf.format(new java.util.Date());
            offre.setDatePublication(dateStr);



            OffreEmploiDAO.CreateEmploi(offre);


            response.sendRedirect("listeOffres");

        } catch (Exception e) {
            request.setAttribute("message", "Erreur: " + e.getMessage());
            request.getRequestDispatcher("Offre.jsp").forward(request, response);
        }


    }


}
