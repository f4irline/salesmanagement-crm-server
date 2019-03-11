package com.github.s1ckcode.SalesManagement;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByName(String name);
}
