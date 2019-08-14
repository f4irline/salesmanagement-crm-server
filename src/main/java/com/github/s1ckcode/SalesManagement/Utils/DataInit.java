package com.github.s1ckcode.SalesManagement.Utils;

import com.github.s1ckcode.SalesManagement.Company.CompanyGoal;
import com.github.s1ckcode.SalesManagement.Company.CompanyGoalRepository;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.Role.Role;
import com.github.s1ckcode.SalesManagement.User.Role.RoleDefinition;
import com.github.s1ckcode.SalesManagement.User.Role.RoleRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DataInit {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    CompanyGoalRepository companyGoalRepository;

    private void initRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(RoleDefinition.ROLE_ADMIN));
        roles.add(new Role(RoleDefinition.ROLE_USER));

        roleRepository.saveAll(roles);
    }

    private void initUsers() {
        Role userRole = roleRepository.findByDefinition(RoleDefinition.ROLE_USER)
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
        Role adminRole = roleRepository.findByDefinition(RoleDefinition.ROLE_ADMIN)
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

        User superAdmin = new User("SUPERADMIN", "ADMIN", "ADMIN", "12345", 0);

        superAdmin.setRoles(new ArrayList<>(Arrays.asList(userRole, adminRole)));

        User jaska = new User("Jaska", "Jaska","Jokunen", "Hash1", 2000.5);

        jaska.setRoles(new ArrayList<>(Arrays.asList(userRole, adminRole)));

        User tiina = new User("Tintti", "Tintti","Lahtinen", "Hash2",3002.5);
        tiina.setRoles(Collections.singleton(userRole));

        List<User> lista = new ArrayList<>();
        lista.add(jaska);
        lista.add(tiina);
        lista.add(superAdmin);

        userRepository.saveAll(lista);
    }

    private void initLeads() {
        Lead tarpatti = new Lead(LocalDate.now(),userRepository.findById((long)100001).get().getUserName(), "Tesoman Tärpätti ja Törpötti","Tislaamo","Keijo Sipilä", "Johto", "0401234567", "keijo@tarpatti.fi", "Prospektointi", Arrays.asList("Yritysvideo", "Yritysilme"), "3", "Tislaamolle mainosvideota");
        tarpatti.setStage("NEW");
        Lead lorpotti = new Lead(LocalDate.now(),userRepository.findById((long)100001).get().getUserName(), "Lempäälän Lörpötti","Panimo","Simo Seinälä", "HR", "0401234567", "simo@lorpotti.fi", "Prospektointi", Arrays.asList("Yritysvideo", "Yritysilme"), "3", "Panimolle mainosvideota");
        lorpotti.setStage("CONTACTED");
        Lead maalaamo = new Lead(LocalDate.now(),userRepository.findById((long)100001).get().getUserName(), "Maalaamo","Maalaus","Keijo Sipilä", "Myynti", "0401234567", "keijo@tarpatti.fi", "Prospektointi", Arrays.asList("Yritysvideo", "Yritysilme"), "3", "Tislaamolle mainosvideota");
        maalaamo.setStage("SOLD");
        Lead pv = new Lead(LocalDate.now(),userRepository.findById((long)100001).get().getUserName(), "Puolustusvoimat","Maanpuolustus","Keijo Sipilä", "Viestintäpäällikkö", "0401234567", "keijo@tarpatti.fi", "Prospektointi", Arrays.asList("Yritysvideo", "Yritysilme"), "3", "Tislaamolle mainosvideota");
        pv.setStage("NEW");
        leadRepository.saveAll(Arrays.asList(tarpatti, lorpotti, maalaamo, pv));
    }

    private void initEvents() {
        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.OFFER, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.OFFER, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.OFFER, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,01,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,02,02),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,03,03),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100002L).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,01,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002L).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,05,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002L).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,06,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100002L).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002L).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002L).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001L).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
    }

    private void initCompanyGoals() {
        companyGoalRepository.save(new CompanyGoal(YearMonth.of(2019, Month.JANUARY),2000.0));
        companyGoalRepository.save(new CompanyGoal(YearMonth.of(2019,Month.FEBRUARY),3000.0));
        companyGoalRepository.save(new CompanyGoal(YearMonth.of(2019,Month.MARCH),4000.0));
    }

    public void initData() {

        initRoles();

        initUsers();

        initLeads();

        initEvents();

        initCompanyGoals();
    }
}
