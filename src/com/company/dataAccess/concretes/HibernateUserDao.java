package com.company.dataAccess.concretes;

import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;
import com.company.entities.dtos.LoginDto;

import java.util.List;

public class HibernateUserDao implements UserDao {
    @Override
    public void add(User user) {
        System.out.println("Hibernate ile eklendi : " + user.getFirstName());
    }

    @Override
    public void update(User user) {
        System.out.println("Hibernate ile güncellendi : " + user.getFirstName());
    }

    @Override
    public void delete(User user) {
        System.out.println("Hibernate ile silindi : " + user.getFirstName());
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User get(int userId) {
        return null;
    }

    //Burası normalde veritabanına gidip bulursa bir user nesnesi döndürmeliydi. Ancak şu an veritabanı olmadığı için null dönüyor.
    @Override
    public User getUserByMail(String email) {
        return null;
    }

}
