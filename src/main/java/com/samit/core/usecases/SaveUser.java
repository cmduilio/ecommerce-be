package com.samit.core.usecases;

import com.samit.configuration.HibernateUtil;
import com.samit.configuration.Main;
import com.samit.core.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.inject.Inject;

public class SaveUser {

    private SelectUser selectUser;

    @Inject
    public SaveUser(SelectUser selectUser) {
        this.selectUser = selectUser;
    }

    public void run(User user){
        HibernateUtil.save("users", user);
    }

    public User update(User userFromBody){
        User user = this.selectUser.run(userFromBody.getId());
        user.update(userFromBody);
        HibernateUtil.update("users", user);
        return user;
    }
}
