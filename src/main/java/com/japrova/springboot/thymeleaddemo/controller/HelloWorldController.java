package com.japrova.springboot.thymeleaddemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // new a controller method to show initial HTML form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form


    @RequestMapping("/")
    public String processForm() {
        return "hello";
    }

    // need a controller method to read form data and
    // add data to the model

    @RequestMapping("/processFormTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String message = "Yo! " + theName;

        model.addAttribute("message", message);

        return "hello";
    }

    @PostMapping("/processFormThree")
    public String processFormThree(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();

        String message = "Yo! " + theName;

        model.addAttribute("message", message);

        return "hello";
    }

}