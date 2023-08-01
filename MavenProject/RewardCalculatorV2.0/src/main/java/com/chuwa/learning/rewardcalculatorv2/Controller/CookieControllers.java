package com.chuwa.learning.rewardcalculatorv2.Controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/cookies")
public class CookieControllers {

    @GetMapping("/setCookie")
    public ResponseEntity<String> setCustomCookie(HttpServletResponse response,
                                                  @RequestParam(name = "cookieName") String cookieName,
                                                  @RequestParam(name = "cookieValue") String cookieValue) {

        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return ResponseEntity.ok("Custom Cookie set successfully!");
    }

    @GetMapping("/getCookie")
    public ResponseEntity<String> getCustomCookie(@RequestParam(name = "cookieName") String cookieName) {

        return ResponseEntity.ok("Custom Cookie: " + cookieName);
    }
}
