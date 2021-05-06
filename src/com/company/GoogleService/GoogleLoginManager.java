package com.company.GoogleService;

public class GoogleLoginManager implements GoogleLoginService{
    @Override
    public void login(String email, String password) {
        System.out.println("Hoşgeldiniz : " + email);
    }
}
