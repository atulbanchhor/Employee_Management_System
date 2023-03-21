package com.emp.demo.Controller;

import com.emp.demo.Entity.Employee;
import com.emp.demo.Service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EMP_Controller {

    @Autowired          // !
    private EmpService service;

    @GetMapping("/")       //to add data into home page
    public String home(Model m) {

        List<Employee> emp = service.getAllEmp();
        m.addAttribute("emp", emp);

        return "index";
    }

    @GetMapping("ADD_EMP")
    public String addemp() {
        return "add_emp";
    }

    @PostMapping("/register")                               // !
    public String empregister(@ModelAttribute Employee e, HttpSession session) {  // in this it is used to set the user input data into employee class
        System.out.println(e);
        service.addEmp(e);
        session.setAttribute("msg", "Employee Added Successfully...");
        return "";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Employee e = service.getEmptById(id);
        m.addAttribute("emp", e);
        return "edit";
    }

    @PostMapping
    public String updateEMP(@ModelAttribute Employee e, HttpSession session) {
        service.addEmp(e);
        session.setAttribute("msg", "EMP Data Update Successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEMP(@PathVariable int id, HttpSession session) {

        service.deleteEMP(id);
        session.setAttribute("msg", "EMP Data Delete Successfully");
        return "redirect:/";
    }
}
