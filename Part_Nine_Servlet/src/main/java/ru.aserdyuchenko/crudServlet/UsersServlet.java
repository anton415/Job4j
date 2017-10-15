package ru.aserdyuchenko.crudServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class UsersServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UsersServlet.class);
    private Map<String, User> users = new HashMap<>();
//    private Storage storage = new Storage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("Hello user!");
        writer.flush();
    }
/*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append("Login: " + login);
        writer.flush();
    }
/*
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            this.storage.add(request.getParameter("login"), request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        this.users.put(request.getParameter("login"), new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate")));
        doGet(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        this.users.remove(request.getParameter("login"));
        doGet(request, response);
    }
*/
}
