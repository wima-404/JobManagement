package servlets;



import dao.CandidatDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Candidat;

import java.io.IOException;
import java.util.Date;
import java.util.List;

class CandidatServlet extends HttpServlet {
    private CandidatDAO candidatDAO;

    public void init() {
        candidatDAO = new CandidatDAO(/* Passer une connexion valide ici */);
    }

    protected void doPost(HttpServletRequest request, HttpServletRequest response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("ajouter".equals(action)) {
            ajouterCandidat(request, (HttpServletResponse) response);
        } else if ("modifier".equals(action)) {
            modifierCandidat(request, (HttpServletResponse) response);
        } else if ("supprimer".equals(action)) {
            supprimerCandidat(request, (HttpServletResponse) response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Candidat> candidats = candidatDAO.afficherCandidats();
        request.setAttribute("candidats", candidats);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listeCandidats.jsp");
        dispatcher.forward(request, response);
    }

    private void ajouterCandidat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Candidat candidat = new Candidat();
        candidat.setNom(request.getParameter("nom"));
        candidat.setPrenom(request.getParameter("prenom"));
        candidat.setEmail(request.getParameter("email"));
        candidat.setMotDePasse(request.getParameter("motDePasse"));
        candidat.setCv(request.getParameter("cv"));
        candidat.setDateInscription(new Date());
        candidatDAO.ajouterCandidat(candidat);
        response.sendRedirect("liste");
    }

    private void modifierCandidat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Candidat candidat = new Candidat();
        candidat.setIdCandidat(Integer.parseInt(request.getParameter("idCandidat")));
        candidat.setNom(request.getParameter("nom"));
        candidat.setPrenom(request.getParameter("prenom"));
        candidat.setEmail(request.getParameter("email"));
        candidat.setMotDePasse(request.getParameter("motDePasse"));
        candidat.setCv(request.getParameter("cv"));
        candidat.setDateInscription(new Date());
        candidatDAO.modifierCandidat(candidat);
        response.sendRedirect("liste");
    }

    private void supprimerCandidat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCandidat = Integer.parseInt(request.getParameter("idCandidat"));
        candidatDAO.supprimerCandidat(idCandidat);
        response.sendRedirect("liste");
    }
}