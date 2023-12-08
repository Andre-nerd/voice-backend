package com.zoomvoice.voice.controller;

import com.zoomvoice.voice.domain.entity.Person;
import com.zoomvoice.voice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/statistic")
public class StatisticController {
    private final UserRepository userRepository;
    @GetMapping()
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = userRepository.findAll();
        return ResponseEntity.ok(persons);
    }
}
