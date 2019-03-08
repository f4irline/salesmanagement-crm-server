package com.github.s1ckcode.SalesManagement;

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
    private String role;
    private String password;
    private final LocalDate createDate = LocalDate.now();

    public User(){}

    public User(String name, LocalDate lastLogin, String role, String password) {
        this.name = name;
        this.lastLogin = lastLogin;
        this.role = role;
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}
