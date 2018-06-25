package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.constant.ViewConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final Log log = LogFactory.getLog(LoginController.class);

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout) {
        log.info("Method: 'showLoginForm()' -- Params: error='" + error + "'&logout='" + logout + "'");

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        return ViewConstant.LOGIN_FORM;
    }

    @GetMapping({"/", "/loginSuccess"})
    public String loginCheck() {
        log.info("Method: 'loginCheck()'");
        return "redirect:/contacts/";
    }
}
