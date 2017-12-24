package ru.aserdyuchenko.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class ServletHome extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletHome.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            synchronized (session) {
                request.setAttribute("role", DataSource.getInstance().getMap().get(session.getAttribute("login")).getRole());
            }
            request.getRequestDispatcher("/WEB-INF/views/homeUser.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
