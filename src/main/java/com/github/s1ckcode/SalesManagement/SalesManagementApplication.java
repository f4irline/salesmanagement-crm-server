package com.github.s1ckcode.SalesManagement;

import com.github.s1ckcode.SalesManagement.Company.CompanyGoal;
import com.github.s1ckcode.SalesManagement.Company.CompanyGoalRepository;
import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Lead.Lead;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

@SpringBootApplication
public class SalesManagementApplication implements CommandLineRunner {

    @Autowired
	UserRepository userRepository;

	@Autowired
    EventRepository eventRepository;

	@Autowired
    LeadRepository leadRepository;

	@Autowired
	CompanyGoalRepository companyGoalRepository;

	public static void main(String[] args) {
		SpringApplication.run(SalesManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Jaska", "Jaska","Jokunen", LocalDate.now(), "ROLE_ADMIN","Hash1",2000.5));
		userRepository.save(new User("Tintti", "Tintti","Lahtinen",LocalDate.now(), "ROLE_USER","Hash2",3002.5));
		userRepository.save(new User("Jesse", "Jesse","Solmunen",LocalDate.now(), "ROLE_ADMIN","Hash2",3002.5));
		userRepository.save(new User("Emilia", "Emilia","Tapola",LocalDate.now(), "ROLE_USER","Hash2",3002.5));
		userRepository.save(new User("Rasmus", "Rasmus","Suo",LocalDate.now(), "ROLE_USER","Hash2",3002.5));
		userRepository.save(new User("Tiina", "Tiina","Toivonen",LocalDate.now(), "ROLE_ADMIN","Hash2",3002.5));

//		//User user, int eventType, String notes, LocalDate date

        //LocalDate date, String companyName, String contactPerson, String contactRole, String phoneNumber, String email, String website, String industry, String notes
        leadRepository.save(new Lead(LocalDate.now(), "Tesoman Tärpätti ja Törpötti","Tislaamo","Keijo Sipilä", "Boss Man", "0401234567", "keijo@tarpatti.fi", "www.torpottiettarpatti.fi", "Tislaamolle mainosvideota"));
		leadRepository.save(new Lead(LocalDate.now(), "Lempäälän Lörpötti","Panimo","Simo Seinälä", "Boss Man", "0401234567", "simo@lorpotti.fi", "www.lempaalanlorpotti.fi", "Panimolle mainosvideota"));


	//(User user, Lead lead, int eventType, String notes, LocalDate date, double sum, String place, String contactPerson, String phoneNumber, String email)

		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));


        eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,01,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,02,02),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,03,03),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,01,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,05,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,06,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        companyGoalRepository.save(new CompanyGoal(YearMonth.of(2019,Month.JANUARY),200.0));
		companyGoalRepository.save(new CompanyGoal(YearMonth.of(2019,Month.FEBRUARY),200.0));
		companyGoalRepository.save(new CompanyGoal(YearMonth.of(2019,Month.MARCH),200.0));

		//leadRepository.save(new Lead(eventRepository.findByEventId(1), "CompanyABC", "Contact123", "5069696969", "pekka@puu.com", "www.pekka.fi"));

	}
}