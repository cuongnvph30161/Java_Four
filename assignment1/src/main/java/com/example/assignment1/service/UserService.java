package com.example.assignment1.service;

import com.example.assignment1.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("nva", "123", "Nguyen Van A", true));
        list.add(new User("nvb", "456", "Nguyen Van B", false));
    }

    public List<User> getAll() {
        return list;
    }

    public void add(User user) {
        list.add(user);
    }

    public User getById(String id) {
        for (User u : list) {
            if (u.getId().equals(id)) return u;
        }
        return null;
    }

    public void update(User user) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(user.getId())) {
                list.set(i, user);
            }
        }
    }
}
