package ru.aserdyuchenko.todo_list.servlet;

import org.apache.log4j.Logger;
import ru.aserdyuchenko.todo_list.models.Item;
import ru.aserdyuchenko.todo_list.storage.DataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class ItemServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ItemServlet.class);

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
//        logger.info("Start doGet method in servlet.");
//        try {
////            HttpSession session = req.getSession();
//            req.getRequestDispatcher("/index.html").forward(req, resp);
//        } catch (ServletException e) {
//            logger.info("ServletException: " + e);
//        } catch (Exception e) {
//            logger.info("Exception: " + e);
//        }
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start doPost method in item servlet.");
        String description = req.getParameter("description").toString();
        Item item = new Item(description);
        DataSource source = new DataSource();
        source.save(item);
        req.getRequestDispatcher("/index.html").forward(req, resp);
    }
}
