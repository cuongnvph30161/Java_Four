package com.example.asm1b2.service;



import com.example.asm1b2.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("nva", "123", "vana@gmail.com", "Nguyen Van A", "VietNam", "Nam", true));
        list.add(new User("nvb", "456", "vana@gmail.com", "Nguyen Van B", "USA", "Nữ", false));
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
    public boolean checkTrungIdUser(String id){
        for (User u : list) {
            if (u.getId().equals(id)) {
                return true; // ID đã tồn tại
            }
        }
        return false; // ID không tồn tại
    }
    public void update(User user) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(user.getId())) {
                list.set(i, user);
            }
        }
    }

    public void deleteUser(User user) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(user.getId())) {
                list.remove(i);
            }
        }
    }

}
