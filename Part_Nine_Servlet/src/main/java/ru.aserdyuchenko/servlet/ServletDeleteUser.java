package ru.aserdyuchenko.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 * @since 05.11.2017 18:30
 */
public class ServletDeleteUser extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletDeleteUser.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            Class.forName("org.postgresql.Driver");
            Storage storage = new Storage();
            storage.delete(request.getParameter("login"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
