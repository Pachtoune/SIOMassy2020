/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Database;
import static dao.PersonneDao.GET_BY_ID_SESSION;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author azery
 */


@WebServlet(name = "confirmationEmail" , urlPatterns = "/confirmationEmail")
public class ConfirmationEmail extends HttpServlet {
    
    private static final String VUE_FORM_CON = "/WEB-INF/connexion.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String Token = request.getParameter("token");
        String vue=VUE_FORM_CON;
        try {
            Connection db = Database.getConnection();
            PreparedStatement stmt = db.prepareStatement("SELECT * from personne where jeton= ? and est_Actif=0");
            stmt.setString(1, Token);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                PreparedStatement stmt1 = db.prepareStatement("UPDATE personne SET est_Actif=1 where jeton= ? ");
                stmt.setString(1, Token);
                int i = stmt1.executeUpdate();
                if(i==1){
                    request.getRequestDispatcher(vue).forward(request, response);
                }
                
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmationEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
