package com.example.contacts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.contacts.models.Person;

@Controller
public class PersonController {
    @GetMapping("/")
    public String index(@ModelAttribute Person person) {
        return "person/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Person person) {
        return "person/create";
    }
}
