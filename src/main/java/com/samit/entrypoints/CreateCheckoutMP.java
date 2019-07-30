package com.samit.entrypoints;

import com.google.inject.Inject;
import com.samit.core.entities.User;
import com.samit.core.usecases.SaveUser;
import com.samit.entrypoints.validators.CreateUserValidator;
import com.samit.utils.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateCheckoutMP implements Route {

    private com.samit.core.usecases.CheckoutMP checkoutMP;

    @Inject
    public CreateCheckoutMP(com.samit.core.usecases.CheckoutMP checkoutMP){
        this.checkoutMP = checkoutMP;
    }

    @Override
    public Object handle(Request request, Response response) {
        //User user = (User) JsonUtils.fromJson(request.body(), User.class);

        String initPoint = this.checkoutMP.run();

        return initPoint;
    }
}