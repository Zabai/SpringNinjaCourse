package com.zarmas.ninjabackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
    private static final String NOT_FOUND = "404";
    private static final String SERVER_ERROR = "500";

    @GetMapping("/404")
    public String showNotFound() {
        return NOT_FOUND;
    }

    @GetMapping("/500")
    public String showServerError() {
        return SERVER_ERROR;
    }
}
