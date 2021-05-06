package com.company.dataAccess.abstracts;

import com.company.entities.concretes.User;
import com.company.entities.dtos.LoginDto;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(User user);
    void delete(User user);
    List<User> getAll();
    User get(int userId);

    User getUserByMail(String email);
}
