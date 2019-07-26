package com.samit.entrypoints.validators;

import com.google.inject.Inject;
import com.samit.core.entities.User;
import com.samit.core.exceptions.CreateUserException;
import com.samit.core.exceptions.NoUserInBodyException;

public class UpdateUserValidator {

    @Inject
    public UpdateUserValidator() {
    }

    public void validate(String userId, User userFromBody){
        try {
            Long.parseLong(userId);
        } catch (Exception e) {
            throw new CreateUserException("No id in url");
        }

        if(userFromBody == null){
            throw new NoUserInBodyException("No user in body");
        }
    }
}
