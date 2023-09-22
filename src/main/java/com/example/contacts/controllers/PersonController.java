package com.example.contacts.controllers;

import javax.naming.Binding;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String create(@Validated @ModelAttribute Person person, BindingResult result) {

        // バリデーションエラーがある場合はindex.htmlを表示
        if (result.hasErrors()) {
            return "person/index";
        }

        return "person/create";
    }
}
