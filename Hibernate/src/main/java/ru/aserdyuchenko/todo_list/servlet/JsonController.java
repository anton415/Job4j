package ru.aserdyuchenko.todo_list.servlet;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import ru.aserdyuchenko.todo_list.models.Item;
import ru.aserdyuchenko.todo_list.storage.DataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JsonController extends HttpServlet{
    private static final Logger logger = Logger.getLogger(ItemServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log from JSON controller.");
        resp.setContentType("text/json");
        String[] checkbox = req.getParameterValues("checkAllItem");
        logger.info("Checkbox: " + checkbox);

        PrintWriter writer = new PrintWriter(resp.getOutputStream());

        try {
            JSONObject jsonItem = new JSONObject();
            DataSource source = new DataSource();
            List<String> list = new ArrayList<>();

            for (Item item : source.getAllItems()) {
                jsonItem.put("id", item.getId())
                        .put("description", item.getDescription())
                        .put("created", item.getCreated())
                        .put("done", item.isDone());
                list.add(jsonItem.toString());
            }
            writer.append(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush();
        }
    }
}
