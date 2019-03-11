package com.github.s1ckcode.SalesManagement;

import org.springframework.data.repository.CrudRepository;

public interface LeadRepository extends CrudRepository<User,Integer> {
    public Lead findUserByLeadId(int leadId);
}