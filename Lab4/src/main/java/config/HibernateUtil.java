
package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static Session session = null;
    private static final SessionFactory sessionFactory;

    static {
        try {
            System.out.println(1);
            Configuration configuration = new Configuration().configure();
            System.out.println(2);
            sessionFactory = configuration.buildSessionFactory();
            System.out.println(3);
            session = sessionFactory.openSession();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        if(session == null)
            session = sessionFactory.openSession();
        return session;
    }

    public static void closeSession() {
        if(session == null)
            return;
        session.close();
        session = null;
    }

}