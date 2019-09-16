package com.samit.core.auth;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class Login implements LoginModule {
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;

    private boolean succeeded = false;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.callbackHandler = callbackHandler;
        this.subject = subject;
        this.sharedState = (Map<String, Object>) sharedState;
        this.options = options;
    }

    public boolean login() throws LoginException {
        System.out.println("Login Module - login called");
        if (this.callbackHandler == null) {
            throw new LoginException("Oops, callbackHandler is null");
        }

        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("name:");
        callbacks[1] = new PasswordCallback("password:", false);

        try {
            this.callbackHandler.handle(callbacks);
        } catch (IOException e) {
            throw new LoginException("Oops, IOException calling handle on callbackHandler");
        } catch (UnsupportedCallbackException e) {
            throw new LoginException("Oops, UnsupportedCallbackException calling handle on callbackHandler");
        }

        NameCallback nameCallback = (NameCallback) callbacks[0];
        PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];

        String name = nameCallback.getName();
        String password = new String(passwordCallback.getPassword());

        if ("myName".equals(name) && "myPassword".equals(password)) {
            System.out.println("Success! You get to log in!");
            this.succeeded = true;
            return this.succeeded;
        } else {
            System.out.println("Failure! You don't get to log in");
            this.succeeded = false;
            throw new FailedLoginException("Sorry! No login for you.");
        }
    }

    public boolean logout() throws LoginException {
        System.out.println("Login Module - logout called");
        return false;
    }


    public boolean abort() throws LoginException {
        System.out.println("Login Module - abort called");
        return false;
    }

    public boolean commit() throws LoginException {
        System.out.println("Login Module - commit called");
        return this.succeeded;
    }
}
