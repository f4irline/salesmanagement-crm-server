package com.github.s1ckcode.SalesManagement.Admin;

import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/admin/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/admin/leads")
    public Iterable<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @GetMapping(value = "/admin/events")
    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @DeleteMapping(value = "/admin/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        }
    }

    @DeleteMapping(value = "/admin/leads/{leadId}")
    public void deleteLead(@PathVariable int leadId) {
        Optional<Lead> leadOptional = leadRepository.findById(leadId);

        if(leadOptional.isPresent()) {
            leadRepository.delete(leadOptional.get());
        }

    }

    @DeleteMapping(value = "/admin/events/{eventId}")
    public void deleteEvent(@PathVariable int eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if(eventOptional.isPresent()) {
            eventRepository.delete(eventOptional.get());
        }

    }

    @PostMapping(value = "/admin/users/edit")
    public void editUser(@RequestBody User user) {
        User tmpUser = userRepository.findById(user.getUserId()).get();
        tmpUser.clone(user);
        userRepository.save(tmpUser);
    }

    @PostMapping(value = "/admin/leads/edit")
    public void editLead(@RequestBody Lead lead) {
        Lead tmpLead = leadRepository.findById(lead.getLeadId()).get();
        tmpLead.clone(lead);
        leadRepository.save(tmpLead);
    }

    @PostMapping(value = "/admin/events/edit")
    public void editEvent(@RequestBody Event event) {
        Event tmpEvent = eventRepository.findById(event.getEventId()).get();
        tmpEvent.clone(event);
        eventRepository.save(tmpEvent);
    }




}
