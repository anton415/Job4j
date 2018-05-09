package ru.aserdyuchenko.todo_list.storage;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aserdyuchenko.todo_list.models.Item;

import java.util.ArrayList;
import java.util.List;


public class DataSource {
    private static final Logger logger = Logger.getLogger(DataSource.class);
//    private SessionFactory factory;
//    private Session session;

    public DataSource() {
//        this.factory = new Configuration()
//                .configure()
//                .buildSessionFactory();
//        session = factory.openSession();
//        session.beginTransaction();
    }

//    public static

    /**
     * Save item.
     * @return true, if save successfully.
     */
    public boolean save(Item item) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try{

            session.saveOrUpdate(item);
            session.getTransaction().commit();
            logger.info("Saving successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
            factory.close();
        }
        return true;
    }

    /**
     * Delete item.
     * @param item what will be delete.
     * @return true if item delete.
     */
    public boolean delete(Item item) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try{

            session.delete(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
            factory.close();
        }
        return true;
    }

    /**
     * Get all items.
     * @return list with all items.
     */
    public List<Item> getAllItems() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Item> list = new ArrayList<Item>();
        try{
            list = session.createQuery("from Item").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
        return list;
    }

    public Item getItemById(int id) {
        Item item = new Item();
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Item> list;
        try{
            list = session.createQuery("from Item i where i.id =" + id).list();
            if (!list.isEmpty()) {

                item = list.get(0);
                logger.info("item: " + item.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
        return item;
    }
}
