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

    private String userName;

    private String userFirst;
    private String userLast;
    private LocalDate lastLogin;

    private String role;

    private double monthlyGoal;
    private @JsonIgnore String password;
    private double goal;
    private final LocalDate createDate = LocalDate.now();

    public User(){}

    public User(String userName, String userFirst, String userLast, LocalDate lastLogin, String role, String password, double monthlyGoal) {
        this.userName = userName;
        this.userFirst = userFirst;
        this.userLast = userLast;
        this.lastLogin = lastLogin;
        this.role = role;
        this.password = Utils.hashMyPassword(password);
        this.monthlyGoal = monthlyGoal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void clone(User user) {

        setUserFirst(user.getUserFirst());
        setUserLast(user.getUserLast());
        setLastLogin(user.getLastLogin());
        setRole(user.getRole());
        setMonthlyGoal(user.getMonthlyGoal());
    }
}
