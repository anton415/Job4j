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
import java.util.List;
import java.util.Map;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 * @since 05.11.2017 18:30
 */
public class ServletAddUser extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletAddUser.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        try {
            Class.forName("org.postgresql.Driver");
            Storage storage = new Storage();
            List<User> users = storage.getList();
            writer.append(
                    "<!DOCTYPE html>" +
                            "<html lang=\"en\">" +
                            "<head>" +
                            "   <meta charset=\"UTF-8\">" +
                            "   <title></title>" +
                            "</head>" +
                            "<body>" +
                            "<a href='"+request.getContextPath()+"'>Home page.</a>" +
                            "<form action='"+request.getContextPath()+"/addUser' method='post'>" +
                            "Login : <input type='text' name='login'/><br/>" +
                            "Name : <input type='text' name='name'/><br/>" +
                            "Email : <input type='text' name='email'/><br/>" +
                            "Date : <input type='text' name='createDate'/><br/>" +
                            "<input type='submit'>" +
                            "</form>" +
                            "</body>" +
                            "</html>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            Class.forName("org.postgresql.Driver");
            Storage storage = new Storage();
            storage.add(request.getParameter("login"), request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
