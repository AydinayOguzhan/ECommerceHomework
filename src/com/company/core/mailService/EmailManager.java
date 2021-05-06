package com.company.core.mailService;

import com.company.entities.concretes.User;

public class EmailManager implements EmailService{
    @Override
    public void sendMail(User user, String message) {
        System.out.println(user.getFirstName() + " " + user.getLastName() + " " + message);
    }
}
