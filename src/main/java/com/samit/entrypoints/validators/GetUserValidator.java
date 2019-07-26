package com.samit.entrypoints.validators;

import com.google.inject.Inject;
import com.samit.core.exceptions.CreateUserException;

public class GetUserValidator {

    @Inject
    public GetUserValidator() {
    }

    public void validate(String userId){
        try {
            Long.parseLong(userId);
        } catch (Exception e) {
            throw new CreateUserException("No id in url");
        }
    }
}
