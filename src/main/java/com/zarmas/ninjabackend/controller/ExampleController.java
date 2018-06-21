package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/example")
public class ExampleController {
    public static final String EXAMPLE_VIEW = "example";

    // First Way
    @GetMapping("/exampleString")
    public String exampleString(Model model) {
        model.addAttribute("people", getPersonList());
        return EXAMPLE_VIEW;
    }

    // Second Way
    @RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
    public ModelAndView exampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("people", getPersonList());

        return mav;
    }

    private List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("General Kenobi", 34));
        personList.add(new Person("Yoda", 99));
        personList.add(new Person("Peter Parker", 24));
        personList.add(new Person("Deadpool", 32));

        return personList;
    }
}
