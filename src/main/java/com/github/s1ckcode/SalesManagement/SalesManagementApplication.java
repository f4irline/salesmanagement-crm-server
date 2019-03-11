package com.github.s1ckcode.SalesManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
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
		userRepository.save(new User("Jaska", LocalDate.now(),"Salesperson","Hash1"));
		userRepository.save(new User("Tintti",LocalDate.now(),"Office dog","Hash2"));
//		//User user, int eventType, String notes, LocalDate date
		eventRepository.save(new Event(userRepository.findByName("Jaska"), Event.CONTACT, "kontaktoitu asiakasta, on kiinnostunut",LocalDate.now()));
        //User user, int eventType, String notes, LocalDate date, Double sum
        eventRepository.save(new Event(userRepository.findByName("Jaska"), Event.SALE, "kauppa tehty alennuksin",LocalDate.of(2019,01,01),200.55));
        //User user, int eventType, String notes, LocalDate date, String place
        eventRepository.save(new Event(userRepository.findByName("Tintti"), Event.MEETING, "tapaaminen sovittu kahvilaan",LocalDate.now(),"Kahvila kulman takana"));

        Iterable<Event> events = (eventRepository.findEventsByUser(userRepository.findByName("Jaska")));
        events.forEach((event -> System.out.println(event.getNotes())) );

		//leadRepository.save(new Lead(eventRepository.findByEventId(1), "CompanyABC", "Contact123", "5069696969", "pekka@puu.com", "www.pekka.fi"));
	}
}