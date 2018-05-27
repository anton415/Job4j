package ru.aserdyuchenko.storage;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.aserdyuchenko.models.Item;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;


public class DataSource {
    private static final Logger logger = Logger.getLogger(DataSource.class);
    private SessionFactory factory;
    private static DataSource instance;

    private DataSource() {
        factory = new Configuration()
                .configure("./todo_list.cfg.xml")
                .buildSessionFactory();
        logger.info("Data source was created");
    }

    public static DataSource getInstance() {
        if(instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public void closeFactory() {
        if(factory != null) {
            factory.close();
            logger.info("Factory close.");
        }
    }

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
    public int save(Item item) {
        try {
            this.tx(
                    session -> session.save(item)
            );
            return item.getId();
        } catch (Exception e) {
            logger.error(e);
            return -1;
        }
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
        if(id == -1) throw new NoSuchElementException();
        List<Item> list = this.tx(
                session -> session.createQuery("from Item i where i.id = " + id).list()
        );
        if (!list.isEmpty()) {
            return list.get(0);
        } else throw new NoSuchElementException();
    }
}
