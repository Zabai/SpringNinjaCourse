package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
    private static final String FORM_VIEW = "form";
    private static final String FORM_RESULT = "result";

    // First way to redirect
    @GetMapping("/")
    public String redirect() {
        return "redirect:/example3/new";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person) {
        ModelAndView mav = new ModelAndView(FORM_RESULT);
        mav.addObject("person", person);
        return mav;
    }
}
