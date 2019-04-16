package com.github.s1ckcode.SalesManagement.Company;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CompanyGoalController {
    @Autowired
    CompanyGoalRepository companyGoalRepository;

    @Autowired
    Utils utils;

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value ="companyChart/get/{startDate}/{endDate}")
    public Iterable<JsonNode> getCompanyGoalData(@PathVariable String startDate, @PathVariable String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return utils.getCompanyChartData(start, end);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/companyGoals/{goalId}")
    public void deleteUser(@PathVariable int goalId) {
        companyGoalRepository.deleteById(goalId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/companyGoals/get/{goalId}")
    public Optional<CompanyGoal> getGoalById(@PathVariable int goalId) {
        return companyGoalRepository.findById(goalId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/companyGoals")
    public void addCompanyGoal(@RequestBody CompanyGoal companyGoal) {
        companyGoalRepository.save(companyGoal);
    }
}
