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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        try {
            Class.forName("org.postgresql.Driver");
            Storage storage = new Storage();
            Map<String, User> users = storage.get();
            Set<Map.Entry<String, User>> list = users.entrySet();

//            writer.append(users.toString());
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
                    "<th>Name</th> " +
                    "<th>Email</th>" +
                    "<th>Create date</th>" +
                    "</tr>");

            for (Map.Entry<String, User> user : list) {
                writer.append("<tr><td>")
                        .append(user.getValue().getName())
                        .append("</td><td>")
                        .append(user.getValue().getEmail())
                        .append("</td><td>")
                        .append(user.getValue().getCreateDate())
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
