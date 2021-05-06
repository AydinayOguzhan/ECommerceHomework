package com.company;

import com.company.GoogleService.GoogleLoginManager;
import com.company.business.abstracts.AuthService;
import com.company.business.abstracts.UserService;
import com.company.business.concretes.AuthManager;
import com.company.business.concretes.GoogleLoginServiceAdapter;
import com.company.business.concretes.UserManager;
import com.company.core.mailService.EmailManager;
import com.company.dataAccess.concretes.HibernateUserDao;
import com.company.entities.concretes.User;
import com.company.entities.dtos.LoginDto;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserManager(new HibernateUserDao());
        //Kendi login servisim
        AuthService authService = new AuthManager(new UserManager(new HibernateUserDao()), new EmailManager());

        //Google'ın sağladığı login servisi
        AuthService authService1 = new GoogleLoginServiceAdapter(new GoogleLoginManager());

        User user = new User(1,"Oğuzhan","Aydınay","aydinayoguzhan@gmail.com","123456");
        LoginDto loginDto = new LoginDto("aydinayoguzhan@gmail.com", "123456");

        authService.register(user);

//        authService.login(loginDto, user);
        authService1.login(loginDto,user);

    }
}
