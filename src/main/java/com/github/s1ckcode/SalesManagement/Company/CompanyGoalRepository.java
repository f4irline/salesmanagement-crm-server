package com.github.s1ckcode.SalesManagement.Company;

import org.springframework.data.repository.CrudRepository;

import java.time.Month;
import java.time.YearMonth;

public interface CompanyGoalRepository extends CrudRepository<CompanyGoal, Integer> {
    CompanyGoal findCompanyGoalByYearMonth(YearMonth yearMonth);
   // double findMonthlyGoalByMonth(Month month);
}
