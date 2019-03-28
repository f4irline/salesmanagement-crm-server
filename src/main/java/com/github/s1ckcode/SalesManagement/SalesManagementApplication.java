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
		userRepository.save(new User("Jaska","Jokunen", LocalDate.now(),User.ADMIN,"Hash1",2000.5));
		userRepository.save(new User("Tintti","Lahtinen",LocalDate.now(),User.USER,"Hash2",3002.5));
		userRepository.save(new User("Jesse","Solmunen",LocalDate.now(),User.USER,"Hash2",3002.5));
		userRepository.save(new User("Emilia","Tapola",LocalDate.now(),User.USER,"Hash2",3002.5));
		userRepository.save(new User("Rasmus","Suo",LocalDate.now(),User.USER,"Hash2",3002.5));
		userRepository.save(new User("Tiina","Toivonen",LocalDate.now(),User.USER,"Hash2",3002.5));

		leadRepository.save(new Lead(LocalDate.now(), "Tesoman Tärpätti ja Törpötti","Tislaamo","Keijo Sipilä", "Boss Man", "0401234567", "keijo@tarpatti.fi", "www.torpottiettarpatti.fi", "Tislaamolle mainosvideota"));
		leadRepository.save(new Lead(LocalDate.now(), "Lempäälän Lörpötti","Panimo","Simo Seinälä", "Boss Man", "0401234567", "simo@lorpotti.fi", "www.lempaalanlorpotti.fi", "Panimolle mainosvideota"));

		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.OFFER, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.OFFER, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.OFFER, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,01,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,02,02),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
		eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,03,03),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,01,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,05,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,06,01),200.0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100002).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));
        eventRepository.save(new Event(userRepository.findById(100001).get(),leadRepository.findById(100001).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),0,"kauppakeskus","Kilohiiri","05049030","@hotmail.com"));

        companyGoalRepository.save(new CompanyGoal(YearMonth.of(2019,Month.JANUARY),2000.0));
		companyGoalRepository.save(new CompanyGoal(YearMonth.of(2019,Month.FEBRUARY),3000.0));
		companyGoalRepository.save(new CompanyGoal(YearMonth.of(2019,Month.MARCH),4000.0));
	}
}