package com.samit.core.usecases;

import com.google.inject.Inject;
import com.samit.configuration.Main;
import com.samit.core.entities.Item;
import com.samit.core.entities.User;
import com.samit.core.exceptions.UserNotFoundException;

public class SelectItem {

    @Inject
    public SelectItem(){}

    public Item run(String id) {
/*        Item user = Main.users.get(Long.parseLong(id));

        if(user == null){
            throw new UserNotFoundException("User nonexistant");
        }
*/
        return null;
    }
}