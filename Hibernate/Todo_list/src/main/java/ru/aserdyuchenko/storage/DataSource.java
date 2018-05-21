package ru.aserdyuchenko.storage;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.aserdyuchenko.models.Item;

import java.util.List;
import java.util.function.Function;


public class DataSource {
    private static final Logger logger = Logger.getLogger(DataSource.class);
    private SessionFactory factory;

    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

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
        return this.tx(
                session -> session.createQuery("from Item").list()
        );
    }

    /**
     * @return list with only not done items.
     */
    public List<Item> getOnlyNotDoneItems() {
        return this.tx(
                session -> session.createQuery("from Item i where i.done = false").list()
        );
    }

    /**
     * @param id - item's id.
     * @return item.
     */
    public Item getItemById(int id) {
        Item item = new Item();
        List<Item> list;
        list = this.tx(
                session -> session.createQuery("from Item i where i.done = false").list()
        );
        if (!list.isEmpty()) {
            item = list.get(0);
            logger.info("item: " + item.toString());
        }
        return item;
    }
}
