package com.company.core.mailService;

import com.company.entities.concretes.User;

public interface EmailService {
    void sendMail(User user, String message);
}
