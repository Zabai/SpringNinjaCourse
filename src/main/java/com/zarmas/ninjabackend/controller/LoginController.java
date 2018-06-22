package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.model.UserCredentialModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final String LOGIN_VIEW = "login";
    private final String CONTACTS_VIEW = "contacts";

    private final Log log = LogFactory.getLog(LoginController.class);

    @GetMapping("/")
    public String redirectToLogin() {
        log.info("Method: 'redirectToLogin()'");

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout) {
        log.info("Method: 'showLoginForm()' -- Params: error='" + error + "'&logout='" + logout + "'");

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("userCredentials", new UserCredentialModel());
        return LOGIN_VIEW;
    }

    @PostMapping("/loginCheck")
    public String loginCheck(@ModelAttribute(name = "userCredentials")UserCredentialModel userCredential) {
        log.info("Method: 'loginCheck()' --- Params: userCredential='" + userCredential.toString() + "'");

        if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user"))
            return CONTACTS_VIEW;
        else
            return "redirect:/login?error";
    }
}
