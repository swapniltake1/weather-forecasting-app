package com.swapnil.weather.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(PATH)
    public String handleError(Model model) {
        // Add any necessary attributes to the model
        return "error-template"; // Return the name of your Thymeleaf error template file
    }

}
