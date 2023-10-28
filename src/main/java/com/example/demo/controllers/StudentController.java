package com.example.demo.controllers;
import com.example.demo.models.Discipline;
import com.example.demo.models.Student;
import com.example.demo.repo.DisciplineRepo;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private DisciplineRepo disciplineRepo;

    @GetMapping("/logout")
    public String logOut(){
        return "logout";
    }

    @GetMapping("/addStudent")
    public String showStudent(){
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String saveStudent(
            @RequestParam String lastname,
            @RequestParam String name,
            @RequestParam String stream_group,
            @RequestParam Date date)
    {
        Student student = new Student(lastname, name, stream_group, date);
        studentRepo.save(student);
        return "redirect:/students";
    }

    @GetMapping("/main")
    public String mainStudent(){
        return "/main";
    }

    @GetMapping("/students")
    public String showAllStudent(Model model){
        Iterable<Student> students = studentRepo.findAll();
        model.addAttribute("students" , students);
        return "students";
    }

    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable(value = "id") long id, Model model){
        Optional<Student> student = studentRepo.findById(id);
        model.addAttribute("student" , student.get());
        return "editStudent";
    }
    @PostMapping("/editStudent")
    public String editStudent(

            @RequestParam long id,
            @RequestParam String lastname,
            @RequestParam String name,
            @RequestParam String stream_group,
            @RequestParam Date date)

    {
        Optional<Student> student = studentRepo.findById(id);
        Student student1 = student.get();
        student1.name = name;
        student1.lastname = lastname;
        student1.stream_group = stream_group;
        student1.date = date;
        studentRepo.save(student1);
        return "redirect:/students";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id){
        studentRepo.deleteById(id);
        return "redirect:/students";
    }
    @GetMapping("/performance/{id}")
    public String studentPerformance(@PathVariable(value = "id") long id, Model model){
        Optional<Student> optionalStudent = studentRepo.findById(id);
        model.addAttribute("optionalStudent",optionalStudent.get());
        Iterable <Discipline> discipline = disciplineRepo.findAll();
        model.addAttribute("discipline", discipline);
        return "performance";
    }
}
