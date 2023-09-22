package com.example.contacts.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Person {
    @NotBlank
    @Size(max = 120)
    private String name;

    @NotNull
    @Min(0)
    @Max(120)
    private Integer age;

    @NotBlank
    @Email
    @Size(max = 254)
    private String email;
}
