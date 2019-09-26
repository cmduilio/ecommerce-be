package com.samit.core.usecases;

import com.samit.configuration.HibernateUtil;
import com.samit.core.entities.Item;
import com.samit.core.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.inject.Inject;

public class SaveItem {

    private SelectUser selectUser;
    private SessionFactory sessionFactory;

    @Inject
    public SaveItem(SelectUser selectUser, SessionFactory sessionFactory) {
        this.selectUser = selectUser;
        this.sessionFactory = sessionFactory;
    }

    public void run(Item item){
        HibernateUtil.save("users", item);
    }

    public User run(User userFromBody, String id){
        /*User user = this.selectUser.run(id);
        user.update(userFromBody);*/
        return null;//user;
    }
}
