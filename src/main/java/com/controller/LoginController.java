package com.controller;

import com.model.UserLoginForm;
import com.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(new UserLoginForm());
        modelAndView.setViewName("loginPage");
        return modelAndView;

    }

    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public String authorizeUser(@ModelAttribute("userLoginForm") UserLoginForm userLoginForm) {
        boolean checkAuthentication = authenticationService.authenticationUser(userLoginForm);

        if (checkAuthentication) {
            return "redirect:/mainPage";

        } else return "redirect:/login";


    }

}
