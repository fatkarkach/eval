package com.Dao;

import com.model.Admin;
import com.model.Responsable;
import com.model.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void insertAdmin() {
        Admin  Admin =new Admin("fatma@gmail.com","12345");
        assertEquals("fatma@gmail.com",Admin.getEmail());
        assertEquals("12345",Admin.getPassword());
    }
    @Test
    void insert() {
          Users users = new Users("fatma", "karkach","irate.2022@gmail.com", "6de0c", "Tanger","marjanT","adminc");
        assertEquals("fatma",users.getNom());
        assertEquals("karkach",users.getPrenom());
        assertEquals("irate.2022@gmail.com",users.getEmail());
        assertEquals("6de0c",users.getPassword());
        assertEquals("Tanger",users.getVille());
        assertEquals("marjanT",users.getCentre());
        assertEquals("adminc",users.getType());

    }
}