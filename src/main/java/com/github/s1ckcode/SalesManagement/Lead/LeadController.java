package com.github.s1ckcode.SalesManagement.Lead;

import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LeadController {

    @Autowired
    LeadRepository leadRepository;
    @Autowired
    EventRepository eventRepository;

    @PostMapping(value="/leads/add")
    public void addLead(@RequestBody Lead lead) {
        if(!leadRepository.findByCompanyNameIgnoreCase(lead.getCompanyName()).isPresent()) {
            leadRepository.save(lead);
        }
    }

    @GetMapping(value ="/leads")
    public Iterable<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

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
