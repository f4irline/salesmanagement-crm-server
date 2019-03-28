package com.github.s1ckcode.SalesManagement.Admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import com.github.s1ckcode.SalesManagement.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private Utils utils;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public enum ObjectType {
        USER,
        LEAD,
        EVENT
    }
    
    @GetMapping(value = "/admin")
    public Iterable<ArrayNode> getAddData() {
        Iterable<User> userList = userRepository.findAll();
        Iterable<Lead> leadList = leadRepository.findAll();
        Iterable<Event> eventList = eventRepository.findAll();

        List<ArrayNode> arrayNodes = new ArrayList<>();
        arrayNodes.add(createArrayNode(userList, ObjectType.USER));
        arrayNodes.add(createArrayNode(leadList, ObjectType.LEAD));
        arrayNodes.add(createArrayNode(eventList, ObjectType.EVENT));

        return arrayNodes;
    }

    private ArrayNode createArrayNode(Iterable<?> list, ObjectType type) {

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();

        switch (type) {
            case USER:

                for(Object user : list) {
                    arrayNode.add(createUserNode((User) user));
                }

                break;

            case LEAD:

                for(Object lead : list) {
                    arrayNode.add(createLeadNode((Lead) lead));
                }

                break;

            case EVENT:

                for(Object event : list) {
                    arrayNode.add(createEventNode((Event) event));
                }

                break;
        }

        return arrayNode;
    }

    private JsonNode createUserNode(User user) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
        ((ObjectNode) node).put("userId", user.getUserId());
        ((ObjectNode) node).put("userFirst",user.getUserFirst());
        ((ObjectNode) node).put("userLast",user.getUserLast());
        ((ObjectNode) node).put("lastLogin", user.getLastLogin().toString());
        ((ObjectNode) node).put("role", user.getRole());
        ((ObjectNode) node).put("monthlyGoal", user.getMonthlyGoal());
        ((ObjectNode) node).put("createDate", user.getCreateDate().toString());

        return node;
    }

    private JsonNode createLeadNode(Lead lead) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
        ((ObjectNode) node).put("lead_id", lead.getLeadId());
        ((ObjectNode) node).put("lead_date", lead.getDate().toString());
        ((ObjectNode) node).put("lead_company_name", lead.getCompanyName());
        ((ObjectNode) node).put("lead_industry", lead.getIndustry());
        ((ObjectNode) node).put("lead_contact_person", lead.getContactPerson());
        ((ObjectNode) node).put("lead_contact_role", lead.getContactRole());
        ((ObjectNode) node).put("lead_phonenumber", lead.getPhoneNumber());
        ((ObjectNode) node).put("lead_email", lead.getEmail());
        ((ObjectNode) node).put("lead_website", lead.getWebsite());
        ((ObjectNode) node).put("lead_notes", lead.getNotes());

        return node;
    }

    private JsonNode createEventNode(Event event) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
        ((ObjectNode) node).put("event_id", event.getEventId());
        ((ObjectNode) node).put("event_type", event.getEventType());
        ((ObjectNode) node).put("event_notes", event.getNotes());
        ((ObjectNode) node).put("event_date", event.getDate().toString());
        ((ObjectNode) node).put("event_sum", event.getSum());
        ((ObjectNode) node).put("event_place", event.getPlace());
        ((ObjectNode) node).put("event_contact_person", event.getContactPerson());
        ((ObjectNode) node).put("event_phonenumber", event.getPhoneNumber());
        ((ObjectNode) node).put("event_email", event.getEmail());

        return node;
    }

    @PostMapping(value = "/admin/users/add")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
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

    @PutMapping(value = "/admin/users/edit")
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
