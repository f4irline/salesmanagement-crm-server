package com.github.s1ckcode.SalesManagement;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event,Integer> {
    public Event findUserByEventId(String eventId);
}
