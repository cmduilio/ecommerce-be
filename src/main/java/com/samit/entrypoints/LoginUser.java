package com.samit.entrypoints;

import com.google.inject.Inject;
import com.samit.core.auth.DefaultCallbackHandler;
import com.samit.core.auth.Login;
import com.samit.core.entities.User;
import com.samit.core.usecases.SaveUser;
import com.samit.entrypoints.validators.CreateUserValidator;
import com.samit.entrypoints.validators.LoginUserValidator;
import com.samit.utils.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class LoginUser implements Route {

    private LoginUserValidator loginUserValidator;

    @Inject
    public LoginUser(LoginUserValidator loginUserValidator){
        this.loginUserValidator = loginUserValidator;
    }

    @Override
    public Object handle(Request request, Response response) {
        User user = (User) JsonUtils.fromJson(request.body(), User.class);

        this.loginUserValidator.validate(user);

        try {
            LoginContext lc = new LoginContext("prod", new DefaultCallbackHandler(user.getUsername(), user.getPassword()));
            lc.login();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}