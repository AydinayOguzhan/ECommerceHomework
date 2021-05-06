package com.company.business.concretes;

import com.company.business.abstracts.UserService;
import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {
    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(user.getEmail());

        if (user.getPassword().length() < 6){
            System.out.println("Parola 6 karakterden daha az olamaz");
            return;
        }if (user.getFirstName().length() < 2 || user.getLastName().length() < 2){
            System.out.println("İsim ve soyisim 2 karakterden daha az olamaz");
        }if (m.find()){
            userDao.add(user);
        }else{
            System.out.println("Email geçersiz");
        }

    }

    @Override
    public User getUserByMail(String email) {
        return userDao.getUserByMail(email);
    }
}
