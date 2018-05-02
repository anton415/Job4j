package ru.aserdyuchenko.todo_list.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.aserdyuchenko.todo_list.models.Item;

import java.util.ArrayList;
import java.util.List;


public class DataSource {

    private SessionFactory factory;
    private Session session;

    public DataSource() {
        this.factory = new Configuration()
                .configure()
                .buildSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
    }

    /**
     * Save item.
     * @return true, if save successfully.
     */
    public boolean save(Item item) {
        try{
            session.saveOrUpdate(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
//            session.close();
//            factory.close();
        }
        return true;
    }

    /**
     * Delete item.
     * @param item what will be delete.
     * @return true if item delete.
     */
    public boolean delete(Item item) {
        try{
            session.delete(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
//            session.close();
//            factory.close();
        }
        return true;
    }

    /**
     * Get all items.
     * @return list with all items.
     */
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<Item>();
        try{
            list = session.createQuery("from Item").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
//            session.close();
//            factory.close();
        }
        return list;
    }
}
