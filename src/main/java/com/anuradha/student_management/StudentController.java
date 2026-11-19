package com.anuradha.student_management;

import com.anuradha.student_management.model.Student;
import com.anuradha.student_management.repository.StudentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Admin Login Page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Admin Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalStudents",
                studentRepository.countStudents());

        return "dashboard";
    }

    // Home Page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    // Add Student
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }

    // Delete Student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentRepository.delete(id);
        return "redirect:/";
    }

    // Edit Student Page
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        model.addAttribute("student", studentRepository.findById(id));
        return "edit";
    }

    // Update Student
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentRepository.update(student);
        return "redirect:/";
    }
}