package edu.miu.cs.cs425.lab9.eregistrarwebapi.controller;

import edu.miu.cs.cs425.lab9.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.lab9.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

/**
 * @author duong at 7/6/2
 * @project eRegistrar
 */
@RestController
@RequestMapping(value="/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list")
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @PostMapping(value = "/register")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(value = "get/{studentId}")
    public Optional<Student> getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId, Model model) {
        studentService.deleteStudent(studentId);
        return "delete success";
    }
}
