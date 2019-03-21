package com.github.s1ckcode.SalesManagement.Company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

@Entity
public class CompanyGoal {

    @Id
    @GeneratedValue
    private  int companyGoalId;
    private YearMonth yearMonth;
    private double monthlyGoal;

    public CompanyGoal(YearMonth yearMonth, double monthlyGoal) {
        this.yearMonth = yearMonth;
        this.monthlyGoal = monthlyGoal;
    }

    public CompanyGoal(){};

    public int getCompanyGoalId() {
        return companyGoalId;
    }

    public void setCompanyGoalId(int companyGoalId) {
        this.companyGoalId = companyGoalId;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public double getMonthlyGoal() {
        return monthlyGoal;
    }

    public void setMonthlyGoal(double monthlyGoal) {
        this.monthlyGoal = monthlyGoal;
    }
}
