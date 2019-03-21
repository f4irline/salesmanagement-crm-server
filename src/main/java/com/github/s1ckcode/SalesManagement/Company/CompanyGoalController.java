package com.github.s1ckcode.SalesManagement.Company;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.s1ckcode.SalesManagement.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class CompanyGoalController {
    @Autowired
    CompanyGoalRepository companyGoalRepository;

    @Autowired
    Utils utils;

    @GetMapping(value ="companyChart/get/{startDate}/{endDate}")
    public Iterable<JsonNode> getCompanyGoalData(@PathVariable String startDate, @PathVariable String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        System.out.println("TÄÄLLÄ");
        return utils.getCompanyChartData(start, end);
    }
}
