package ru.aserdyuchenko.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class ServletHome extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletHome.class);

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
                            "<a href='"+request.getContextPath()+"/getUser'>Get users.</a><br/>" +
                            "<a href='"+request.getContextPath()+"/addUser'>Add users.</a><br/>" +
                            "<a href='"+request.getContextPath()+"/editUser'>Edit users.</a><br/>" +
                            "<a href='"+request.getContextPath()+"/deleteUser'>Delete users.</a><br/>"

                            );
            writer.append(
                    "</body>" +
                    "</html>");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
        }
    }
}
