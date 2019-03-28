package com.github.s1ckcode.SalesManagement.Lead;

import com.github.s1ckcode.SalesManagement.User.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LeadRepository extends CrudRepository<Lead,Integer> {
    Optional<Lead> findByCompanyNameIgnoreCase(String companyName);
}