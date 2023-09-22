package com.example.contacts.controllers;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.contacts.models.Person;
import com.example.contacts.repository.PersonRepository;

@Controller
public class PersonController {

    // Personクラスのフィールドをfinalにする
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(@ModelAttribute Person person, Model model) {
        // 一覧用データの用意
        model.addAttribute("people", repository.findAll());
        return "person/index";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Person person, BindingResult result, Model model) {

        // バリデーションエラーがある場合はindex.htmlを表示
        if (result.hasErrors()) {
            model.addAttribute("people", repository.findAll());
            return "person/index";
        }
        repository.saveAndFlush(person);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    // 初期データの投入
    @PostConstruct
    public void dataInit() {
        Person suzuki = new Person();
        suzuki.setName("鈴木");
        suzuki.setAge(23);
        suzuki.setEmail("test@test.com");
        repository.saveAndFlush(suzuki);

        Person sato = new Person();
        sato.setName("佐藤");
        sato.setAge(20);
        sato.setEmail("sato@test.com");
        repository.saveAndFlush(sato);
    }

}
