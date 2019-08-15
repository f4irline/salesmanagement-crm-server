package com.github.s1ckcode.SalesManagement.Lead;

import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LeadController {

    @Autowired
    LeadRepository leadRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;

    @PreAuthorize("hasRole('USER')")
    @PostMapping(value="/leads/add/{userId}")
    public void addLead(@RequestBody Lead lead, @PathVariable long userId) {
        if(!leadRepository.findByCompanyNameIgnoreCase(lead.getCompanyName()).isPresent()) {
            User user = userRepository.findById(userId).get();
            lead.setUserName(user.getUserName());
            lead.setUser(user);
            lead.setStage("NEW");
            leadRepository.save(lead);
        }
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping(value="/leads/close/{leadId}")
    public void closeLead(@PathVariable int leadId) {
        Lead tmpLead = leadRepository.findById(leadId).get();
        tmpLead.clone(leadRepository.findById(leadId).get());
        tmpLead.setStage("CLOSED");
        leadRepository.save(tmpLead);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/leads/{leadId}")
    public Lead getLead(@PathVariable int leadId) {
        return leadRepository.findById(leadId).get();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value ="/leads")
    public Iterable<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/leads/{leadId}")
    public void deleteLead(@PathVariable int leadId) {
        Iterable<Event> events = eventRepository.findEventsByLead(leadRepository.findById(leadId).get());
        for(Event event:events) {
            if(event.getLead() != null) {
                event.setLead(null);
            }
        }
        leadRepository.deleteById(leadId);
    }
}
