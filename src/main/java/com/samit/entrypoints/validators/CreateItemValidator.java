package com.samit.entrypoints.validators;

import com.google.inject.Inject;
import com.samit.core.entities.Item;
import com.samit.core.exceptions.NoMailException;
import com.samit.core.exceptions.NoPasswordException;
import com.samit.core.exceptions.NoUserInBodyException;
import com.samit.core.exceptions.NoUsernameException;

public class CreateItemValidator {

    @Inject
    public CreateItemValidator() {
    }

    public void validate(Item item){
        /*if(item == null){
            throw new NoUserInBodyException("No user in body");
        }

        if(item.getUsername() == null || item.getUsername().isEmpty()){
            throw new NoUsernameException("No Username in body");
        }

        if(item.getPassword() == null || item.getPassword().isEmpty()){
            throw new NoPasswordException("No Password in body");
        }

        if(item.getMail() == null || item.getMail().isEmpty()){
            throw new NoMailException("No mail in body");
        }*/
    }
}
