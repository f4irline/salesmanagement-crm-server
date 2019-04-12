package com.github.s1ckcode.SalesManagement.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
    Boolean existsByUserName(String userName);
}
