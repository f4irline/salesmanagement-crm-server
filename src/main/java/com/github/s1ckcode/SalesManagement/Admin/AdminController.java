package com.github.s1ckcode.SalesManagement.Admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.Role.Role;
import com.github.s1ckcode.SalesManagement.User.Role.RoleDefinition;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import com.github.s1ckcode.SalesManagement.Utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    public enum ObjectType {
        USER,
        LEAD,
        EVENT
    }

    @PreAuthorize("hasRole('ADMIN')")
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

        JsonNodeFactory f = JsonNodeFactory.instance ;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();

        ObjectNode roleNode = f.objectNode();
        ArrayNode arrayNode = roleNode.putArray("roles");

        for (Role role : user.getRoles()) {
            arrayNode.add(role.getDefinition().toString());
        }

        String lastLogin;

        if (user.getLastLogin() == null) {
            lastLogin = "never";
        } else {
            lastLogin = user.getLastLogin().toString();
        }

        ((ObjectNode) node).put("userId", user.getUserId());
        ((ObjectNode) node).put("createDate", user.getCreateDate().toString());
        ((ObjectNode) node).put("lastLogin", lastLogin);
        ((ObjectNode) node).put("userFirst",user.getUserFirst());
        ((ObjectNode) node).put("userLast",user.getUserLast());
        ((ObjectNode) node).putArray("roles").add(arrayNode);
        ((ObjectNode) node).put("monthlyGoal", user.getMonthlyGoal());

        return node;
    }

    private JsonNode createLeadNode(Lead lead) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
        ((ObjectNode) node).put("leadId", lead.getLeadId());
        ((ObjectNode) node).put("date", lead.getDate().toString());
        ((ObjectNode) node).put("companyName", lead.getCompanyName());
        ((ObjectNode) node).put("industry", lead.getIndustry());
        ((ObjectNode) node).put("contactPerson", lead.getContactPerson());
        ((ObjectNode) node).put("contactRole", lead.getContactRole());
        ((ObjectNode) node).put("phoneNumber", lead.getPhoneNumber());
        ((ObjectNode) node).put("email", lead.getEmail());
        ((ObjectNode) node).put("website", lead.getWebsite());
        ((ObjectNode) node).put("notes", lead.getNotes());

        return node;
    }

    private JsonNode createEventNode(Event event) {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
        ((ObjectNode) node).put("userName", event.getUser().getUserName());
        ((ObjectNode) node).put("leadCompanyName", event.getLead().getCompanyName());
        ((ObjectNode) node).put("eventId", event.getEventId());
        ((ObjectNode) node).put("date", event.getDate().toString());
        ((ObjectNode) node).put("contactPerson", event.getContactPerson());
        ((ObjectNode) node).put("phoneNumber", event.getPhoneNumber());
        ((ObjectNode) node).put("email", event.getEmail());
        ((ObjectNode) node).put("eventType", event.getEventType());
        ((ObjectNode) node).put("sum", event.getSum());
        ((ObjectNode) node).put("place", event.getPlace());
        ((ObjectNode) node).put("notes", event.getNotes());

        return node;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/admin/users/add")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/admin/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User tmpUser = userRepository.findById(userId).get();
        userRepository.save(tmpUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/admin/leads/{leadId}")
    public void deleteLead(@PathVariable int leadId) {
        Lead tmpLead = leadRepository.findById(leadId).get();
        leadRepository.delete(tmpLead);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/admin/events/{eventId}")
    public void deleteEvent(@PathVariable int eventId) {
        Event tmpEvent = eventRepository.findById(eventId).get();
        eventRepository.delete(tmpEvent);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/admin/users/edit")
    public void editUser(@RequestBody User user) {
        User tmpUser = userRepository.findById(user.getUserId()).get();
        tmpUser.clone(user);

        tmpUser.setRoles(user.getRoles());

        userRepository.save(tmpUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/admin/leads/edit")
    public void editLead(@RequestBody Lead lead) {
        Lead tmpLead = leadRepository.findById(lead.getLeadId()).get();
        tmpLead.clone(lead);
        leadRepository.save(tmpLead);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/admin/events/edit/{leadId}")
    public void editEvent(@RequestBody Event event, @PathVariable int leadId) {
        Event tmpEvent = eventRepository.findById(event.getEventId()).get();
        tmpEvent.clone(event);

        tmpEvent.setLead(leadRepository.findById(leadId).get());
        tmpEvent.setCompanyName(tmpEvent.getLead().getCompanyName());

        eventRepository.save(tmpEvent);
    }
}
