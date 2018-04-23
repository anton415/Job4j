package ru.aserdyuchenko.servlet;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import ru.aserdyuchenko.storage.DataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 * @since 05.11.2017 18:30
 */
public class ServletEditUser extends HttpServlet {
    Logger logger = Logger.getLogger(ServletEditUser.class);

    public void init() {
        org.apache.log4j.BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            logger.info("Hello this is an info message, from doGet method in ServletEditUser.java");
            HttpSession session = request.getSession();
            synchronized (session) {
                request.setAttribute("role", DataSource.getInstance().getMap().get(session.getAttribute("login")).getRole());
                request.setAttribute("login", session.getAttribute("login"));
                request.setAttribute("users", DataSource.getInstance().getList());
            }

            request.getRequestDispatcher("/edit.html").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            HttpSession session = request.getSession();
            synchronized (session) {
                Class.forName("org.postgresql.Driver");
                DataSource storage = DataSource.getInstance();
                System.out.println("get parameter: " + request.getParameter("role"));
//                if (session.getAttribute("role").toString().equals("admin")) {
//                    storage.update(request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate"), request.getParameter("login"), request.getParameter("password"), request.getParameter("role"));
//                } else if(session.getAttribute("role").toString().equals("user")) {
//                    storage.update(request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate"), session.getAttribute("login").toString(), request.getParameter("password"), request.getParameter("role"));
//                }
                if (request.getParameter("role").toString().equals("admin")) {
                    storage.update(request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate"), request.getParameter("login"), request.getParameter("password"), request.getParameter("role"));
                } else if(request.getParameter("role").toString().equals("user")) {
                    storage.update(request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate"), session.getAttribute("login").toString(), request.getParameter("password"), request.getParameter("role"));
                }
                response.sendRedirect(String.format("%s/editUser", request.getContextPath()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
