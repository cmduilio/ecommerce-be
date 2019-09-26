package com.samit.entrypoints;

import com.google.inject.Inject;
import com.samit.core.entities.User;
import com.samit.core.usecases.SaveUser;
import com.samit.entrypoints.validators.UpdateUserValidator;
import com.samit.utils.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;

public class UpdateUser implements Route {

    private UpdateUserValidator updateUserValidator;
    private SaveUser saveUser;

    @Inject
    public UpdateUser(UpdateUserValidator updateUserValidator, SaveUser saveUser){
        this.updateUserValidator = updateUserValidator;
        this.saveUser = saveUser;
    }

    @Override
    public Object handle(Request request, Response response) {
        User userFromBody = (User) JsonUtils.fromJson(request.body(), User.class);
        String idParam = request.params("userId");
        this.updateUserValidator.validate(idParam, userFromBody);
        Long id = Long.valueOf(idParam);
        userFromBody.setId(id);
        return this.saveUser.update(userFromBody);
    }
}