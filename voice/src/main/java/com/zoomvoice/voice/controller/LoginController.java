package com.zoomvoice.voice.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("")
    public String hello(){
        return "redirect:/api";
    }
    @GetMapping("login")
    public String login(){
        return "login";
    }
}
