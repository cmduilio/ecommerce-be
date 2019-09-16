package com.samit.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.samit.core.entities.Item;
import com.samit.core.exceptions.*;
import com.samit.core.usecases.CheckoutMP;
import com.samit.core.usecases.SaveUser;
import com.samit.core.usecases.SelectUser;
import com.samit.entrypoints.*;
import com.samit.core.entities.User;
import com.samit.utils.JsonUtils;
import org.apache.http.HttpStatus;
import org.hibernate.SessionFactory;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main extends AbstractModule {

    public static Map<Long, User> users = new HashMap<>();
    public static Map<Long, Item> items = new HashMap<>();
    //public static Map<Long, Order> orders = new HashMap<>();

    public static void main(String[] args) {
        System.setProperty("java.security.auth.login.config", "src/main/resources/jaas.config");

        Injector injector = Guice.createInjector(new Main());

        port(8080);

        //before("/*", (request,response) -> response.type("application/json"));

        before("/*", Main::beforeRoutes);

        get("/api/user/:userId", injector.getInstance(GetUser.class), JsonUtils::toJson);

        put("/api/user/:userId", injector.getInstance(UpdateUser.class), JsonUtils::toJson);

        post("/api/user", injector.getInstance(CreateUser.class), JsonUtils::toJson);

        post("/api/login", injector.getInstance(LoginUser.class), JsonUtils::toJson);

        post("/api/checkout", injector.getInstance(CreateCheckoutMP.class), JsonUtils::toJson);

    }

    @Override
    protected void configure() {

        // DB
        bind(SessionFactory.class).toInstance(HibernateUtil.getSessionFactory());

        // GET
        bind(GetUser.class);

        // PUT
        bind(UpdateUser.class);

        // POST
        bind(CreateUser.class);
        bind(CreateCheckoutMP.class);

        // USECASES
        bind(CheckoutMP.class);
        bind(SaveUser.class);
        bind(SelectUser.class);

        // EXCEPTION
        exception(CreateUserException.class, this::badRequest);
        exception(NoMailException.class, this::badRequest);
        exception(NoPasswordException.class, this::badRequest);
        exception(NoUserInBodyException.class, this::badRequest);
        exception(NoUsernameException.class, this::badRequest);
        exception(UserNotFoundException.class, this::notFound);
    }

    //create a handler or something?
    private void badRequest(Exception exception, Request req, Response res) {
        res.status(HttpStatus.SC_BAD_REQUEST);
        res.body("");
    }

    private void notFound(Exception exception, Request req, Response res) {
        res.status(HttpStatus.SC_NOT_FOUND);
        res.body("");
    }

    private static void beforeRoutes(Request request, Response response){
        response.header("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        response.header("Access-Control-Allow-Origin", "*");
        response.header("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        response.header("Access-Control-Allow-Credentials", "true");
        response.header("Content-Type","application/json");
    }
}
