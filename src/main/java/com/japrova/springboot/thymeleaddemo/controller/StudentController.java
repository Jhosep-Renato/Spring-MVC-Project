package com.japrova.springboot.thymeleaddemo.controller;

import com.japrova.springboot.thymeleaddemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {


    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        // create a student object
        Student theStudent = new Student();

        // add student object to the model
        model.addAttribute("theStudent", theStudent);

        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("theStudent") Student theStudent) {

        System.out.println("Student: " + theStudent.getFirstName() + " "
                + theStudent.getLastName());

        return "student-confirmation";
    }
}
