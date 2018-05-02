package ru.aserdyuchenko.todo_list.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemServlet extends HttpServlet {

    @Override
    public void log(String msg) {
        super.log(msg);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.getRequestDispatcher("/index.html").forward(req, resp);
        } catch (Exception e) {
            log("Exception: " + e);
        }
    }
}
