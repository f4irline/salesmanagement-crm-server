package com.github.s1ckcode.SalesManagement.User;

import com.github.s1ckcode.SalesManagement.User.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByName(String name);
}
