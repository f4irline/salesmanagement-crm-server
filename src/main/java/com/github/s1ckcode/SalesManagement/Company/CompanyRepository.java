package com.github.s1ckcode.SalesManagement.Company;

import org.springframework.data.repository.CrudRepository;

import java.time.Month;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    public double getMonthlyGoalByMonth(Month month);
}
