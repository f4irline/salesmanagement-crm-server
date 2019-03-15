package com.github.s1ckcode.SalesManagement.Company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Month;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private  int companyId;
    private Month month;
    private double monthlyGoal;

    public Company(Month month, double monthlyGoal) {
        this.month = month;
        this.monthlyGoal = monthlyGoal;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public double getMonthlyGoal() {
        return monthlyGoal;
    }

    public void setMonthlyGoal(double monthlyGoal) {
        this.monthlyGoal = monthlyGoal;
    }
}
