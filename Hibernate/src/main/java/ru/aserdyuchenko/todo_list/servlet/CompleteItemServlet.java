package ru.aserdyuchenko.todo_list.servlet;

import org.apache.log4j.Logger;
import ru.aserdyuchenko.todo_list.models.Item;
import ru.aserdyuchenko.todo_list.storage.DataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompleteItemServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ItemServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start doPost method in complete item servlet.");
        String[] checkbox = req.getParameterValues("checkbox");
        logger.info("Checkbox: " + checkbox);
//        Item item = new Item(checkbox);
//        DataSource source = new DataSource();
//        source.save(item);
        req.getRequestDispatcher("/index.html").forward(req, resp);
    }
}
