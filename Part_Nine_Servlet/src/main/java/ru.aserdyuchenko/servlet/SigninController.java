package ru.aserdyuchenko.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class SigninController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            Как только я комментиру вывод LoginView.jsp и добавляю Items.html
            При старте сервера у меня вылетает NullPointException в ServletHome.java:22
            Я не могу понять почему и не знаю как это исправить.
         */
//        req.getRequestDispatcher("/WEB-INF/views/LoginView.jsp").forward(req, resp);
        req.getRequestDispatcher("/Items.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if (DataSource.getInstance().isCredentional(login, password)) {
                HttpSession session = req.getSession();
                synchronized (session) {
                    session.setAttribute("login", login);
                    if(req.getParameter("button1") != null) {
                        session.invalidate();
                    }
                }
                resp.sendRedirect(String.format("%s/", req.getContextPath()));
            } else {
                req.setAttribute("error", "Credentional invalid");
                doGet(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
