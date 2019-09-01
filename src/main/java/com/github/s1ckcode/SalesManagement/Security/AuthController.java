package com.github.s1ckcode.SalesManagement.Security;

import com.github.s1ckcode.SalesManagement.Security.auth.ApiResponse;
import com.github.s1ckcode.SalesManagement.Security.auth.bruteforce.LoginAttemptService;
import com.github.s1ckcode.SalesManagement.Security.auth.jwt.JwtAuthResponse;
import com.github.s1ckcode.SalesManagement.Security.auth.jwt.JwtTokenizer;
import com.github.s1ckcode.SalesManagement.Security.auth.requests.LoginRequest;
import com.github.s1ckcode.SalesManagement.Security.auth.requests.RegisterRequest;
import com.github.s1ckcode.SalesManagement.User.User;
import com.github.s1ckcode.SalesManagement.User.UserRepository;
import com.github.s1ckcode.SalesManagement.User.Role.Role;
import com.github.s1ckcode.SalesManagement.User.Role.RoleDefinition;
import com.github.s1ckcode.SalesManagement.User.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtTokenizer tokenizer;

    @Autowired
    LoginAttemptService loginAttemptService;

    @RequestMapping(value="/csrf-token", method=RequestMethod.GET)
    public @ResponseBody String getCsrfToken(HttpServletRequest request) {
        CsrfToken token = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
        return token.getToken();
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        String userName = loginRequest.getUserName();
        if(loginAttemptService.isBlocked(userName)) {
            return new ResponseEntity<>("",HttpStatus.FORBIDDEN);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenizer.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest signUpRequest) {
        if(userRepository.existsByUserName(signUpRequest.getUserName())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Username already taken."));
        }

        User user = new User(signUpRequest.getUserName(), signUpRequest.getUserFirst(), signUpRequest.getUserLast(),
                signUpRequest.getPassword(), signUpRequest.getMonthlyGoal());

        Role userRole = roleRepository.findByDefinition(RoleDefinition.ROLE_USER)
                .orElseThrow(() -> new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUserName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
