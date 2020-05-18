/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MembresCanalDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Membre;

/**
 *
 * @author Cissé-LENOVO
 */
@WebServlet("/ajouterMembresCanal")
public class AjouterMembresCanal extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String VUE_OK = "WEB-INF/ajouterMembresCanal.jsp";
    /**
     * Vue si erreur (exception)
     */
    private static final String VUE_ERREUR = "WEB-INF/exception.jsp";
    private int idCanal;
    private int idPersonne;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vue = VUE_OK;
        //response.sendRedirect("ajouterMembresCanal?idCanal=1");
        request.getRequestDispatcher(vue).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String vue = VUE_OK;

        MembresCanalDao dao = new MembresCanalDao();
        try {
            int idCanal = Integer.parseInt(request.getParameter("id_canal"));

        } catch (NumberFormatException e) {
            request.setAttribute("message", "Veuillez saisir un entier pour l'idCanal");
        }
        try {
            int idPersonne = Integer.parseInt(request.getParameter("id_personne"));
        } catch (NumberFormatException e2) {
            request.setAttribute("message", "Veuillez saisir un entier pour l'idPersonne");

        }
        try {
            Membre membre = new Membre();
            membre.setIdCanal(idCanal);
            membre.setIdPersonne(idPersonne);
            dao.ajouterMembre(membre);
            //URL Rewritting
            //response.sendRedirect("ajouterMembresCanal?idCanal=1");

        } catch (SQLException exc) {

            request.setAttribute("exception", exc);

            vue = VUE_ERREUR;
        }

        request.getRequestDispatcher(vue).forward(request, response);

    }

}
