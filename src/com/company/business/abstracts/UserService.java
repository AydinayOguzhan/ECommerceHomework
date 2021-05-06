package com.company.business.abstracts;

import com.company.entities.concretes.User;

public interface UserService {
    void add(User user);
    User getUserByMail(String email);
}
