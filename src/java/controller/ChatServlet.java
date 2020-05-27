 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
// reponds sur whatsapp stp 
import dao.CanalDao;
import static dao.CanalDao.CanalAffiche;
import dao.MessageDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Canal;
import modele.CanalAffiche;
import modele.Message;


@WebServlet(name = "ChatServlet", urlPatterns = {"/chat"})
public class ChatServlet extends HttpServlet {

    private static final String VUE_OK = "WEB-INF/chat.jsp";
    private static final String VUE_ERREUR = "WEB-INF/exception.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vue = VUE_OK;

        try {
            
            List<CanalAffiche> canauxAffiche = CanalDao.CanalAffiche();
            request.setAttribute("canauxAffiche", canauxAffiche);
            /**List<Canal> canaux = CanalDao.getAll();
            request.setAttribute("canaux", canaux);
            System.out.println("test passé" + canaux.size());**/
        } catch (SQLException exc) {
            exc.printStackTrace();
            request.setAttribute("exception", exc);
            vue = VUE_ERREUR;
        }
       
       


        request.getRequestDispatcher(vue).forward(request, response);
    }

}

