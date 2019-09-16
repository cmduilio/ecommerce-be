package com.samit.core.usecases;

import com.samit.configuration.Main;
import com.samit.core.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.inject.Inject;

public class SaveUser {

    private SelectUser selectUser;
    private SessionFactory sessionFactory;

    @Inject
    public SaveUser(SelectUser selectUser, SessionFactory sessionFactory) {
        this.selectUser = selectUser;
        this.sessionFactory = sessionFactory;
    }

    public void run(User user){
//        user.setId(Long.valueOf(Main.users.size() + 1));
//        Main.users.put(user.getId(), user);

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public User run(User userFromBody, String id){
        User user = this.selectUser.run(id);
        user.update(userFromBody);
        return user;
    }
}
