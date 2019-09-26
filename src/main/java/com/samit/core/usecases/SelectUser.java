package com.samit.core.usecases;

import com.google.inject.Inject;
import com.samit.configuration.HibernateUtil;
import com.samit.core.entities.User;
import com.samit.core.exceptions.UserNotFoundException;
import org.hibernate.SessionFactory;

public class SelectUser {
    private SessionFactory sessionFactory;

    @Inject
    public SelectUser(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public User run(Long id) {
        User user = HibernateUtil.get(User.class, id);

        if(user == null){
            throw new UserNotFoundException("User nonexistant");
        }

        return user;
    }
}