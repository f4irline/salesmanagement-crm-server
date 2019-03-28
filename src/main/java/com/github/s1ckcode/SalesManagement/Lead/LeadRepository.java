package com.github.s1ckcode.SalesManagement.Lead;

import com.github.s1ckcode.SalesManagement.User.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LeadRepository extends CrudRepository<Lead,Integer> {
    Optional<Lead> findByCompanyNameIgnoreCase(String companyName);
}