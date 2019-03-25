package com.github.s1ckcode.SalesManagement.Event;

import com.github.s1ckcode.SalesManagement.User.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface EventRepository extends CrudRepository<Event,Integer> {
    public Iterable<Event> findEventsByUser(User user);
    public Iterable<Event> findEventsByEventTypeAndUser(int eventType, User user);
    public Iterable<Event> findEventsByDateBetween(LocalDate startDate, LocalDate endDate);
    public Iterable<Event> findEventsByDate(LocalDate date);
    //public Iterable<Event> findEventsByDateMonth(Month month);
}
