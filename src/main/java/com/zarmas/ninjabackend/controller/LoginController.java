package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.model.UserCredentialModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private final String LOGIN_VIEW = "login";
    private final String CONTACTS_VIEW = "contacts";

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout) {
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("userCredentials", new UserCredentialModel());
        return LOGIN_VIEW;
    }

    @PostMapping
    public String loginCheck(@ModelAttribute(name = "userCredentials")UserCredentialModel userCredential) {
        if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user"))
            return CONTACTS_VIEW;
        else
            return "redirect:/login?error";
    }
}
