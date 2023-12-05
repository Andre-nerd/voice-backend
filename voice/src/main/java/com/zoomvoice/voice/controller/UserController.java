package com.zoomvoice.voice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class UserController {

    @GetMapping("user")
    public String getUserList() {
        System.out.println("Hello page working");
        return "show";
    }
}
