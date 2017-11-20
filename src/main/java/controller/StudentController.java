package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import entity.Student;
import service.StudentService;


@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        ModelAndView mv = new ModelAndView("student", "command", new Student());
        mv.addObject("studentNumber", service.showAllStudent().size());
        return mv;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void home(){

    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("command") Student student,
                             ModelMap model) {
        if (service.insertUser(student.getName(), student.getAge(), student.getId())) {
            model.addAttribute("name", student.getName());
            model.addAttribute("age", student.getAge());
            model.addAttribute("id", student.getId());
            return "result";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/consultStudent", method = RequestMethod.GET)
    public ModelAndView consultStudent() {
        ModelAndView mv = new ModelAndView("consultStudent");
        mv.addObject("studentList", service.showAllStudent());
        return mv;
    }

    @RequestMapping(value = "/deleteStudent", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView deleteStudent(@RequestParam(value = "idunique") int idunique) {
        if (service.deleteStudent(idunique)) {
            return new ModelAndView("redirect:/consultStudent");
        } else {
            return new ModelAndView("redirect:/consultStudent");
        }
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcomepage() {
        ModelAndView mv = new ModelAndView("welcomePage");
        mv.addObject("string", "hello from you sb");
        return mv;
    }

    @RequestMapping(value = "/back2main", method = RequestMethod.GET )
    public ModelAndView back2MainPage() {
        return new ModelAndView("redirect:/student");
    }
}
