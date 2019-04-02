package com.github.s1ckcode.SalesManagement.Event;

import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    LeadRepository leadRepository;

    @PostMapping(value = "/events/add/{userId}/{leadId}")
    public void addEvent(@RequestBody Event event, @PathVariable int userId, @PathVariable int leadId) {
        event.setUser(userRepository.findById(userId).get());
        event.setLead(leadRepository.findById(leadId).get());
        eventRepository.save(event);
    }

    @GetMapping(value = "/events/{userId}")
    public Iterable<Event> getAllEventsFromUser(@PathVariable int userId) {
        return eventRepository.findEventsByUser(userRepository.findById(userId).get());
    }

    @GetMapping(value = "/events")
    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @DeleteMapping(value = "/events/{eventId}")
    public void deleteEvent(@PathVariable int eventId) {
        eventRepository.deleteById(eventId);
    }

}
