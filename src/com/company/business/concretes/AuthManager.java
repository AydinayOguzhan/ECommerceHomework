package com.company.business.concretes;

import com.company.business.abstracts.AuthService;
import com.company.business.abstracts.UserService;
import com.company.core.mailService.EmailService;
import com.company.entities.concretes.User;
import com.company.entities.dtos.LoginDto;

public class AuthManager implements AuthService {
    private UserService userService;
    private EmailService emailService;

    public AuthManager(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @Override
    public void login(LoginDto loginDto, User user) {
        //Burada normalde işlem userService'ten gelecek cevabın user1 nesnesine atanması ile işlemeliydi.
        //Sorgular user1'in içindeki verileri kullanmalıydı ancak şu an veritabanımız olmadığı için login işlemi yaparken user nesnesi
        //alıyoruz.
        var user1 = userService.getUserByMail(loginDto.getEmail());
        if (user == null){
            System.out.println("Böyle bir kullanıcı sistemde mevcut değildir");
        }else{
            if (loginDto.getPassword().equals(user.getPassword())){
                System.out.println("Hoşgeldiniz : " + user.getFirstName());
            }else{
                System.out.println("Hatalı şifre");
            }
        }
    }

    @Override
    public void register(User user) {
        //Burada normalde işlem userService'ten gelecek cevabın user1 nesnesine atanması ile işlemeliydi.
        //Sorgular user1'in içindeki verileri kullanmalıydı ancak şu an veritabanımız olmadığı için bu sorgu geçersiz.
        //Sistemin hata vermemesi için bu kodu yorum satırı haline getirdim.

//        var user1 = userService.getUserByMail(user.getEmail());
//        if (user1.getEmail().equals(user.getEmail())){
//            System.out.println("Kullanıcı sistemde mevcut");
//        }else{
//        }
        userService.add(user);
        emailService.sendMail(user, "Lütfen emailinize gelen linkten hesabınızı onaylayınız.");
    }
}
