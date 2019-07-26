package com.samit.core.usecases;

import com.google.inject.Inject;
import com.samit.configuration.Main;
import com.samit.core.entities.User;
import com.samit.core.exceptions.UserNotFoundException;
import com.samit.entrypoints.validators.GetUserValidator;
import spark.Request;
import spark.Response;
import spark.Route;

public class SelectUser {

    @Inject
    public SelectUser(){}

    public User run(String id) {
        User user = Main.users.get(Long.parseLong(id));

        if(user == null){
            throw new UserNotFoundException("User nonexistant");
        }

        return user;
    }
}