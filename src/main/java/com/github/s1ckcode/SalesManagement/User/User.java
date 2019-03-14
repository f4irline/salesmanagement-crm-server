package com.github.s1ckcode.SalesManagement.User;

import com.github.s1ckcode.SalesManagement.Utils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int userId;
    private String name;
    private LocalDate lastLogin;
    private int role;
    private String password;
    private final LocalDate createDate = LocalDate.now();

    public static int USER = 0;
    public static int ADMIN = 1;

    public User(){}

    public User(String name, LocalDate lastLogin, int role, String password) {
        this.name = name;
        this.lastLogin = lastLogin;
        this.role = role;
        this.password = Utils.hashMyPassword(password);
    }

    public User(String name, int role, String password) {
        this.name = name;
        this.lastLogin = LocalDate.now();
        this.role = role;
        this.password = Utils.hashMyPassword(password);
    }

    public void setUserId(int userId){ this.userId = userId; }

    public int userId() {
        return userId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = this.password = Utils.hashMyPassword(password);
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}
