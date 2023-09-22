package com.example.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contacts.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
