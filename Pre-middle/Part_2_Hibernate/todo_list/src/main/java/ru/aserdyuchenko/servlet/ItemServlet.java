package ru.aserdyuchenko.servlet;

import org.apache.log4j.Logger;
import ru.aserdyuchenko.models.Item;
import ru.aserdyuchenko.storage.DataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ItemServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start doPost method in item servlet.");
        String description = req.getParameter("description").toString();
        Item item = new Item(description);
        DataSource source = DataSource.getInstance();
        source.save(item);
        req.getRequestDispatcher("/index.html").forward(req, resp);
    }
}
