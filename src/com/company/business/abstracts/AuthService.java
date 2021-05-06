package com.company.business.abstracts;

import com.company.entities.concretes.User;
import com.company.entities.dtos.LoginDto;

public interface AuthService {
    //Normalde burada user alınmaz. Veritabanı olmadığı için kullanıcının varlığını şimdilik böyle kontrol ediyorum.
    void login(LoginDto loginDto, User user);
    void register(User user);
}
