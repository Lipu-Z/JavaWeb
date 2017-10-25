package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import entity.Student;
import service.StudentService;


@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("student", "command", new Student());
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("command") Student student,
                             ModelMap model) {
        if(service.insertUser(student.getName(), student.getAge(), student.getId())) {
            model.addAttribute("name", student.getName());
            model.addAttribute("age", student.getAge());
            model.addAttribute("id", student.getId());
            return "result";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/consultStudent", method = RequestMethod.GET)
    public String consultStudent() {
        return "error";
    }
}
