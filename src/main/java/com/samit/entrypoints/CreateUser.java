package com.samit.entrypoints;

import com.google.inject.Inject;
import com.samit.core.entities.User;
import com.samit.core.usecases.SaveUser;
import com.samit.entrypoints.validators.CreateUserValidator;
import com.samit.utils.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateUser implements Route {

    private CreateUserValidator createUserValidator;
    private SaveUser saveUser;

    @Inject
    public CreateUser(CreateUserValidator createUserValidator, SaveUser saveUser){
        this.createUserValidator = createUserValidator;
        this.saveUser = saveUser;
    }

    @Override
    public Object handle(Request request, Response response) {
        User user = (User) JsonUtils.fromJson(request.body(), User.class);

        this.createUserValidator.validate(user);

        this.saveUser.run(user);

        return user;
    }
}