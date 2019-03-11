package com.github.s1ckcode.SalesManagement.Event;

import com.github.s1ckcode.SalesManagement.User.User;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event,Integer> {
    public Iterable<Event> findEventsByUser(User user);
}
