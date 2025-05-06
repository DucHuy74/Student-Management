package vn.proj.spring.studentmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // ✅ Đúng import
import org.springframework.web.bind.annotation.*;
import vn.proj.spring.studentmanage.entity.Student;
import vn.proj.spring.studentmanage.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listAll(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/students";
    }

    @GetMapping("/create")
    public String create(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "/student/students-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student){
        studentService.updateStudent(student);
        return "redirect:/api/students/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "/student/students-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        studentService.deleteStudentById(id);
        return "redirect:/api/students/list";
    }
}
