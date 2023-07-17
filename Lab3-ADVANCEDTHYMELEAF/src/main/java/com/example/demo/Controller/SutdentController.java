package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Student;
import com.example.demo.Model.Student2;

import jakarta.validation.Valid;

@Controller
public class SutdentController {
    @GetMapping("/Student/form")
    public String form(Model model) {
        Student student = new Student();
        model.addAttribute("sv", student);
        return "Student/form";
    }

    @PostMapping("/Student/save")
    public String save(@ModelAttribute("sv") Student form) {
        return "Student/success";
    }

    @GetMapping("/Student/form2")
    public String form2(Model model) {
        Student2 student = new Student2();
        model.addAttribute("sv", student);
        return "Validation/form";
    }

    @PostMapping("/Student/save2")
    public String save2(@Valid @ModelAttribute("sv") Student2 form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("msg", "Có lỗi, vui lòng sửa");
            return "Validation/form";
        }
        return "Validation/success";
    }

}
