package com.github.s1ckcode.SalesManagement.Utils;

import com.github.s1ckcode.SalesManagement.User.Role.Role;
import com.github.s1ckcode.SalesManagement.User.Role.RoleDefinition;
import com.github.s1ckcode.SalesManagement.User.Role.RoleRepository;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInit {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    private void initRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(RoleDefinition.ROLE_ADMIN));
        roles.add(new Role(RoleDefinition.ROLE_USER));

        roleRepository.saveAll(roles);
    }

    private void initUsers() {
        Role userRole = roleRepository.findByDefinition(RoleDefinition.ROLE_USER)
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
        Role adminRole = roleRepository.findByDefinition(RoleDefinition.ROLE_ADMIN)
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

        User superAdmin = new User("VC_ADMIN", "ADMIN", "ADMIN", "QSMNVP4i2P", 0);

        superAdmin.setRoles(new ArrayList<>(Arrays.asList(userRole, adminRole)));

        userRepository.save(superAdmin);
    }

    public void initData() {

        initRoles();

        initUsers();
    }
}
