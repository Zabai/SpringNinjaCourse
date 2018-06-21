package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {
    public static final String EXAMPLE_VIEW = "example";

    // First Way
    @GetMapping("/exampleString")
    public String exampleString(Model model) {
        model.addAttribute("person", new Person("General Kenobi", 34));
        return EXAMPLE_VIEW;
    }

    // Second Way
    @RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
    public ModelAndView exampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("person", new Person("Yoda", 99));

        return mav;
    }
}
