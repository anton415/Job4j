package ru.aserdyuchenko.todo_list.servlet;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ItemServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("Test log");
        try{
            req.getRequestDispatcher("/index.html").forward(req, resp);
        } catch (Exception e) {
            logger.info("Exception: " + e);
        }
    }
}
