package com.report.dao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.report.entities.Student;

@Controller
public class StudentController {
	private final StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("/enter-data")
    public String showEnterDataForm() {
        return "enter_data"; // This will return the enter_data.html template
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute Student student) {
        try {
            // Assuming you have the StudentRepo interface with the save method
            studentRepo.save(student);
            return "redirect:/enter-data?success=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/enter-data?error=true";
        }
    }

}
