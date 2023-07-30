package com.chuwa.redbook.controller;

import com.chuwa.redbook.dao.security.RoleRepository;
import com.chuwa.redbook.dao.security.UserRepository;
import com.chuwa.redbook.entity.security.Role;
import com.chuwa.redbook.entity.security.User;
import com.chuwa.redbook.payload.security.LoginDto;
import com.chuwa.redbook.payload.security.SignUpDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Enumeration;

/**
 * @author b1go
 * @date 6/26/22 5:03 PM
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getAccountOrEmail(), loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Cookie themeCookie = new Cookie("dark-mode", "true");
        themeCookie.setMaxAge(86400);
        response.addCookie(themeCookie);

        Cookie languageCookie = new Cookie("lang", "eng");
        languageCookie.setMaxAge(86400);
        response.addCookie(languageCookie);

        return new ResponseEntity<>("User sign-in successfully!", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {

        // check if username is in a DB
        if (userRepository.existsByAccount(signUpDto.getAccount())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // check if email exists in DB
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setAccount(signUpDto.getAccount());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getSessionDetails")
    public ResponseEntity<String> getSessionDetails(@CookieValue("JSESSIONID") String jsessionId, HttpSession session){
        if(session.getId().equals(jsessionId)){
            Enumeration<String> attributeNames = session.getAttributeNames();
            logger.info("Session ID: {}", session.getId());
            while(attributeNames.hasMoreElements()){
                String attributeName = attributeNames.nextElement();
                Object attributeValue = session.getAttribute(attributeName);
                logger.info("Attribute: {} - Value: {}", attributeName, attributeValue);
            }
            return new ResponseEntity<>("Session details logged successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to log session details", HttpStatus.NOT_FOUND);
        }
    }
}
