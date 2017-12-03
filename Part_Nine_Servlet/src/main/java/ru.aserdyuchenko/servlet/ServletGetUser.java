package ru.aserdyuchenko.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 * @since 05.11.2017 18:30
 */
public class ServletGetUser extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletGetUser.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users", DataSource.getInstance().getList());
            request.getRequestDispatcher("/WEB-INF/views/getUser.jsp").forward(request, response);
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}