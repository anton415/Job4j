package ru.aserdyuchenko.todo_list.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class ItemServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ItemServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Get from servlet. Test log.");
        logger.info("Get from servlet.");
        try {
            HttpSession session = req.getSession();

//            synchronized (session) {
//                String login = session.getAttribute("login").toString();
////                request.setAttribute("role", getRoleByLogin(login));
////                request.setAttribute("login", session.getAttribute("login"));
////                request.setAttribute("users", DataSource.getInstance().getList());
//            }

            req.getRequestDispatcher("/index.html").forward(req, resp);
//        } catch (SQLException e) {
//            logger.info("SQLException: " + e);
        } catch (ServletException e) {
            logger.info("ServletException: " + e);
        } catch (IOException e) {
            logger.info("IOException: " + e);
        }
    }
}
