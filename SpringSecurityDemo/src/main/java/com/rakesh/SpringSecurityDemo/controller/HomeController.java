package com.rakesh.SpringSecurityDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String greet(HttpServletRequest req)
    {
        return "Hello world ! "+req.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest req)
    {
        return "Telusko "+req.getSession().getId();
    }
}
