package controller;

import dao.MessageDao;
import dao.PersonneDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Message;
import modele.Personne;

/**
 *
 * @author akber
 */
@WebServlet(name = "MessageServlet", urlPatterns = {"/canal"})
public class CanalServlet extends HttpServlet {

    private static final String VUE_OK = "WEB-INF/canal.jsp";
    private static final String VUE_ERREUR = "WEB-INF/exception.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vue = VUE_OK;
        int idSession = 1;
        
        try {
            int idCanal = Integer.parseInt(request.getParameter("idCanal"));
            List<Personne> stagiaire = PersonneDao.getByIdSessionFormation(idSession);
            request.setAttribute("stagiaire", stagiaire);
            request.setAttribute("idSession", idSession);
            MessageDao dao = new MessageDao();
            List<Message> messages = MessageDao.getMessage(idCanal);
            request.setAttribute("messages", messages);

        } catch (SQLException exc) {
            exc.printStackTrace();
            request.setAttribute("exception", exc);
            vue = VUE_ERREUR;
        }

        request.getRequestDispatcher(vue).forward(request, response);
    }

}
