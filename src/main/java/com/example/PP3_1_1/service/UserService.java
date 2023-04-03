package com.example.PP3_1_1.service;

import com.example.PP3_1_1.dao.UserDao;
import com.example.PP3_1_1.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUser() {
        return userDao.findAll();
    }

    public User getUserId(int id) {
        return userDao.getOne(id);
    }

    public void addUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(int id) {
        userDao.deleteById(id);
    }
}
