package com.github.s1ckcode.SalesManagement.User.Role;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByDefinition(RoleDefinition definition);
}
