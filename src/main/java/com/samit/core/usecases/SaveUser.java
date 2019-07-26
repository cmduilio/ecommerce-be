package com.samit.core.usecases;

import com.samit.configuration.Main;
import com.samit.core.entities.User;

import javax.inject.Inject;

public class SaveUser {

    private SelectUser selectUser;

    @Inject
    public SaveUser(SelectUser selectUser) {
        this.selectUser = selectUser;
    }

    public void run(User user){
        user.setId(Long.valueOf(Main.users.size() + 1));
        Main.users.put(user.getId(), user);
    }

    public User run(User userFromBody, String id){
        User user = this.selectUser.run(id);
        user.update(userFromBody);
        return user;
    }
}
