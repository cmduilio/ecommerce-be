package com.samit.entrypoints.validators;

import com.google.inject.Inject;
import com.samit.core.entities.User;
import com.samit.core.exceptions.NoMailException;
import com.samit.core.exceptions.NoPasswordException;
import com.samit.core.exceptions.NoUserInBodyException;
import com.samit.core.exceptions.NoUsernameException;

public class CreateUserValidator {

    @Inject
    public CreateUserValidator() {
    }

    public void validate(User user){
        if(user == null){
            throw new NoUserInBodyException("No user in body");
        }

        if(user.getUsername() == null || user.getUsername().isEmpty()){
            throw new NoUsernameException("No Username in body");
        }

        if(user.getPassword() == null || user.getPassword().isEmpty()){
            throw new NoPasswordException("No Password in body");
        }

        if(user.getMail() == null || user.getMail().isEmpty()){
            throw new NoMailException("No mail in body");
        }
    }
}
