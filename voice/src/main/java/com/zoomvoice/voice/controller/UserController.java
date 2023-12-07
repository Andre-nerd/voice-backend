package com.zoomvoice.voice.controller;


import com.zoomvoice.voice.domain.entity.Person;
import com.zoomvoice.voice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class UserController {
    private final UserRepository userRepository;

    @GetMapping()
    public String index(Model model) {
        List<Person> persons = userRepository.findAll();
        model.addAttribute("people", persons);
        return "index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) throws BadRequestException {
        Optional<Person> person = userRepository.findById(id);
        if (person.isPresent()) {
            model.addAttribute("person", person.get());
            return "show";
        }
        throw new BadRequestException("id is not correct");
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/api";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("person", userRepository.findById(id).get());
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()){
            return "edit";
        }
        userRepository.save(person);
        return "redirect:/api";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        log.info("save " + person);
        userRepository.save(person);
        return "redirect:/api";
    }
}
