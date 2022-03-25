package com.example.demoapp.utils;

import com.example.demoapp.model.User;

import java.util.List;

public interface UserContract {
    interface View {
        void retrieveUsers(List<User> list);
        void retrieveSingleUser(User user);
        void addOneUserResult(User user);
        void updateOneUserResult(User user);
        void deleteOneUserResult(User user);
    }
    interface Presenter {
        void getAllUser();
        void getOneUser();
        void addOneUser();
        void updateOneUser();
        void deleteOneUser();
    }
}
