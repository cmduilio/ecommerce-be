package com.samit.entrypoints;

import com.google.inject.Inject;
import com.samit.core.usecases.SelectUser;
import com.samit.entrypoints.validators.GetUserValidator;
import spark.Request;
import spark.Response;
import spark.Route;

public class GetUser implements Route {

    private GetUserValidator getUserValidator;
    private SelectUser selectUser;

    @Inject
    public GetUser(GetUserValidator getUserValidator, SelectUser selectUser){
        this.getUserValidator = getUserValidator;
        this.selectUser = selectUser;
    }

    @Override
    public Object handle(Request request, Response response) {
        String idParam = request.params("userId");
        this.getUserValidator.validate(idParam);
        Long id = Long.valueOf(idParam);
        return this.selectUser.run(id);
    }
}