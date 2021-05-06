package com.company.business.concretes;

import com.company.GoogleService.GoogleLoginService;
import com.company.business.abstracts.AuthService;
import com.company.entities.concretes.User;
import com.company.entities.dtos.LoginDto;

public class GoogleLoginServiceAdapter implements AuthService {
    private GoogleLoginService googleLoginService;

    public GoogleLoginServiceAdapter(GoogleLoginService googleLoginService) {
        this.googleLoginService = googleLoginService;
    }

    @Override
    public void login(LoginDto loginDto, User user) {
        googleLoginService.login(loginDto.getEmail(), loginDto.getPassword());
    }

    @Override
    public void register(User user) {
        return;
    }
}
