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
public class ServletEditUser extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletEditUser.class);

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
                            "<table style=\"width:100%\">" +
                            "<tr>" +
                            "<th>Login</th> " +
                            "<th>Name</th> " +
                            "<th>Email</th>" +
                            "<th>Create date</th>" +
                            "</tr>");

            for (User user : users) {
                writer.append("<tr><td>")
                        .append(user.getLogin())
                        .append("</td><td>")
                        .append(user.getName())
                        .append("</td><td>")
                        .append(user.getEmail())
                        .append("</td><td>")
                        .append(user.getCreateDate())
                        .append("</td></tr>");
            }

            writer.append("</table>" +
                    "</form>" +
                    "<br/>" +
                    "<br/>" +
                    "<form action='"+request.getContextPath()+"/editUser' method='post'>" +
                    "Name : <input type='text' name='name'/><br/>" +
                    "Email : <input type='text' name='email'/><br/>" +
                    "Date : <input type='text' name='createDate'/><br/>" +
                    "Login : <input type='text' name='login'/><br/>" +
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
            storage.update(request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate"), request.getParameter("login"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
