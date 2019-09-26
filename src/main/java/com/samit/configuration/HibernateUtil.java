package com.samit.configuration;

import java.io.Serializable;
import java.util.Properties;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import com.samit.core.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, "jdbc:h2:mem://localhost:9092/~/creditpolicy;MODE=mysql");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/cp?allowPublicKeyRetrieval=true&useSSL=false");
                settings.put(Environment.USER, "jc");
                settings.put(Environment.PASS, "12345678");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                configuration.setProperties(settings);

                EntityScanner.scanPackages("com.samit.core.entities")
                        .addTo(configuration);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static <T> T get(Class<T> entity, Serializable id){
        T object = null;
        try (Session session = sessionFactory.openSession()) {
            object = session.get(entity, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void save(String entity, Object user){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(entity, user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public static void update(String entity, Object user){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(entity, user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
