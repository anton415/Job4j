package ru.aserdyuchenko.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class ServletHome extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletHome.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        synchronized (session) {
            if (session == null || session.getAttribute("login") == null) {
                response.sendRedirect(String.format("%s/signin", request.getContextPath()));
            } else {
                request.getRequestDispatcher("/WEB-INF/views/homeUser.jsp").forward(request, response);

            }
        }
    }
}
