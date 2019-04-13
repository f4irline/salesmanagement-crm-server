package com.github.s1ckcode.SalesManagement.Event;

import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('USER')")
    @PostMapping(value = "/events/add/{userId}/{leadId}")
    public void addEvent(@RequestBody Event event, @PathVariable Long userId, @PathVariable int leadId) {
        event.setUser(userRepository.findById(userId).get());
        event.setLead(leadRepository.findById(leadId).get());
        switch (event.getEventType()) {
            case 3:
                leadRepository.findById(leadId).get().setStage("SOLD");
                break;
            default:
                leadRepository.findById(leadId).get().setStage("CONTACTED");
        }

        eventRepository.save(event);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/event/{eventId}")
    public Event getEventById(@PathVariable int eventId) {
        return eventRepository.findById(eventId).get();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/events/{userId}")
    public Iterable<Event> getAllEventsFromUser(@PathVariable Long userId) {
        return eventRepository.findEventsByUser(userRepository.findById(userId).get());
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/events")
    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/events/{eventId}")
    public void deleteEvent(@PathVariable int eventId) {
        eventRepository.deleteById(eventId);
    }

}
