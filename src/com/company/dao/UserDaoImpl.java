package com.company.dao;

import com.company.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao{
    private final String fileName;
    private List<User> users;

    public UserDaoImpl(String fileName) {
        this.fileName = fileName;
        try(
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            users = (List<User>) inputStream.readObject();
        } catch(IOException | ClassNotFoundException ex) {
            users = new ArrayList<>();
        }
    }

    @Override
    public void save() {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(users);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<User> allUsers() {
        return users;
    }

    @Override
    public User findById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst().orElseThrow();
    }

    @Override
    public boolean register(User user) {
        Optional<User> existedUser = users.stream()
                .filter(u ->
                        u.getNickname().equals(user.getNickname())
                ).findFirst();
        if(existedUser.isPresent()) {
            return false;
        }
        users.add(user);
        return true;
    }

    @Override
    public boolean auth(User user) {
        Optional<User> existingUser = users.stream()
                .filter(u -> u.getNickname().equals(user.getNickname())
                        && u.getPassword().equals(user.getPassword())).findAny();

        if(existingUser.isPresent()) {
            user.setId(existingUser.get().getId());
            return true;
        }
        return false;
    }
}
