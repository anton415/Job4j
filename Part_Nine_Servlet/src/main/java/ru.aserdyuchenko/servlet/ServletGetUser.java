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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 * @since 05.11.2017 18:30
 */
public class ServletGetUser extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletGetUser.class);
    public static List<User> users;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        try {
            Class.forName("org.postgresql.Driver");
            Storage storage = new Storage();
            this.users = storage.getList();
            writer.append(
                    "<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "   <meta charset=\"UTF-8\">" +
                    "   <title></title>" +
                    "</head>" +
                    "<body>" +
                    "<a href='"+request.getContextPath()+"'>Home page.</a>" +
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
                    "</body>" +
                    "</html>");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
        }
    }
}
