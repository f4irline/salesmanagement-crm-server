package com.github.s1ckcode.SalesManagement.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.s1ckcode.SalesManagement.Utils;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {
    @TableGenerator(name = "User_Gen",
            table = "USER_ID_GEN",
            pkColumnName = "USER_ID",
            valueColumnName = "GEN_VAL",
            pkColumnValue = "User_Gen",
            initialValue = 100000,
            allocationSize = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "User_Gen")
    private int userId;
    private String userFirst;
    private String userLast;
    private LocalDate lastLogin;
    private int role;
    private double monthlyGoal;
    private @JsonIgnore String password;
    private double goal;
    private final LocalDate createDate = LocalDate.now();

    public static int USER = 0;
    public static int ADMIN = 1;

    public User(){}

    public User(String userFirst, String userLast, LocalDate lastLogin, int role, String password, double monthlyGoal) {
        this.userFirst = userFirst;
        this.userLast = userLast;
        this.lastLogin = lastLogin;
        this.role = role;
        this.password = Utils.hashMyPassword(password);
        this.monthlyGoal = monthlyGoal;
    }

    public void setUserId(int userId){ this.userId = userId; }

    public int getUserId() {
        return userId;
    }

    public String getUserFirst() {
        return userFirst;
    }

    public void setUserFirst(String userFirst) {
        this.userFirst = userFirst;
    }

    public String getUserLast() {
        return userLast;
    }

    public void setUserLast(String userLast) {
        this.userLast = userLast;
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

    public double getMonthlyGoal() {
        return monthlyGoal;
    }

    public void setMonthlyGoal(double monthlyGoal) {
        this.monthlyGoal = monthlyGoal;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}
