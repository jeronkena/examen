package com.company.dao;

import com.company.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    User findById(int id);
    boolean register(User user);
    boolean auth(User user);
    default void save() {
        throw new UnsupportedOperationException();
    }
}
