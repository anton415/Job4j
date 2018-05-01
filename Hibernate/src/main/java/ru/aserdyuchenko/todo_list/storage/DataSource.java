package ru.aserdyuchenko.todo_list.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aserdyuchenko.todo_list.models.Item;


public class DataSource {

    public DataSource() {

    }

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setDescription("Simple task.");

        session.save(item);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public boolean save(Item item) {
        try{

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {

        }
        return true;
    }
}
