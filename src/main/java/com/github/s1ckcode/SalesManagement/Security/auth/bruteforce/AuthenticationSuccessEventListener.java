package com.github.s1ckcode.SalesManagement.Security.auth.bruteforce;

import com.github.s1ckcode.SalesManagement.User.UserPrincipalImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationSuccessEventListener
        implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private LoginAttemptService loginAttemptService;

    public void onApplicationEvent(AuthenticationSuccessEvent e) {

        UserPrincipalImpl auth = (UserPrincipalImpl)
                e.getAuthentication().getPrincipal();

        String userName = auth.getUsername();

        loginAttemptService.loginSucceeded(userName);
    }

}