package com.github.s1ckcode.SalesManagement.Lead;

import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LeadController {

    @Autowired
    LeadRepository leadRepository;

    @PostMapping(value="/leads/add")
    public void addLead(@RequestBody Lead lead) {
        if(leadRepository.findByCompanyNameContainingIgnoreCase(lead.getCompanyName()) == null) {
            leadRepository.save(lead);
        }
    }

    @GetMapping(value ="/leads")
    public Iterable<Lead> getAllLeads() {
        return leadRepository.findAll();
    }
}
