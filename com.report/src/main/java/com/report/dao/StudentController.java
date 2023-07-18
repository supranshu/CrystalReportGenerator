package com.report.dao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String saveStudentData(@RequestParam int rollNumber,
                                  @RequestParam String name,
                                  @RequestParam String year,
                                   @RequestParam String branch,
                                  @RequestParam String attendance) {
        Student student = new Student();
        student.setRollNumber(rollNumber);
        student.setName(name);
        student.setYear(year);
        student.setBranch(branch);
        student.setAttendance(attendance);

        studentRepo.save(student); // Save the student data to the database

        return "redirect:/"; // Redirect back to the index page
    }
}
