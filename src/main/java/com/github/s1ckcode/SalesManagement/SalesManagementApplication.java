package com.github.s1ckcode.SalesManagement;

import com.github.s1ckcode.SalesManagement.Event.Event;
import com.github.s1ckcode.SalesManagement.Event.EventRepository;
import com.github.s1ckcode.SalesManagement.Lead.LeadRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SalesManagementApplication implements CommandLineRunner {

    @Autowired
	UserRepository userRepository;

	@Autowired
    EventRepository eventRepository;

	@Autowired
    LeadRepository leadRepository;

	public static void main(String[] args) {
		SpringApplication.run(SalesManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Jaska","Jokunen", LocalDate.now(),User.ADMIN,"Hash1"));
		userRepository.save(new User("Tintti","Ala-Hintti",LocalDate.now(),User.USER,"Hash2"));
//		//User user, int eventType, String notes, LocalDate date
		eventRepository.save(new Event(userRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now()));
		eventRepository.save(new Event(userRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now()));
		eventRepository.save(new Event(userRepository.findById(100001).get(), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now()));

        eventRepository.save(new Event(userRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,01,01),200.0));
		eventRepository.save(new Event(userRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,02,02),100.0));
		eventRepository.save(new Event(userRepository.findById(100001).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,03,03),150.0));

        eventRepository.save(new Event(userRepository.findById(100002).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,01,01),10000.0));
        eventRepository.save(new Event(userRepository.findById(100002).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,05,01),10600.0));
        eventRepository.save(new Event(userRepository.findById(100002).get(), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,06,01),10500.0));

        eventRepository.save(new Event(userRepository.findById(100002).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),"Kahvila kulman takana"));
        eventRepository.save(new Event(userRepository.findById(100002).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),"Kahvila kulman takana"));
        eventRepository.save(new Event(userRepository.findById(100002).get(), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),"Kahvila kulman takana"));

		//leadRepository.save(new Lead(eventRepository.findByEventId(1), "CompanyABC", "Contact123", "5069696969", "pekka@puu.com", "www.pekka.fi"));
	}
}