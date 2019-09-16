package com.samit.core.auth;

import java.io.IOException;
import javax.security.auth.callback.*;

public class DefaultCallbackHandler implements CallbackHandler {

    private String name;
    private String password;

    public DefaultCallbackHandler(String name, String password) {
        System.out.println("Callback Handler - constructor called");
        this.name = name;
        this.password = password;
    }

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("Callback Handler - handle called");
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callbacks[i];
                nameCallback.setName(this.name);
            } else if (callbacks[i] instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callbacks[i];
                passwordCallback.setPassword(this.password.toCharArray());
            } else {
                throw new UnsupportedCallbackException(callbacks[i], "The submitted Callback is unsupported");
            }
        }
    }
}
