package com.github.s1ckcode.SalesManagement.User;

import com.github.s1ckcode.SalesManagement.Security.auth.bruteforce.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


import javax.servlet.http.HttpServletRequest;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private LoginAttemptService loginAttemptService;

    @Override
    @Transactional
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(loginAttemptService.isBlocked(username)) {
            throw new RuntimeException("blocked");
        }
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipalImpl(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found, id: " + id));

        if(notSameLogin(user.getCurrentLogin(), user.getLastLogin())) {
            user.setLastLogin(user.getCurrentLogin());
        }

        user.setCurrentLogin(LocalDateTime.now());

        return new UserPrincipalImpl(user);
    }

    private boolean notSameLogin(LocalDateTime newDate, LocalDateTime oldDate) {

        long tenSeconds = 10000;
        long aMillis = newDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long bMillis = oldDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        LocalDate aDate = newDate.toLocalDate();
        LocalDate bDate = oldDate.toLocalDate();

        if(!aDate.equals(bDate)) {
            return true;
        } else if(aMillis > bMillis + tenSeconds) {
            return true;
        }

        return false;
    }

}
