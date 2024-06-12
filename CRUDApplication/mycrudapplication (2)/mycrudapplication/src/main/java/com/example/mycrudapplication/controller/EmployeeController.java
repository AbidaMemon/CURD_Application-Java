package com.example.mycrudapplication.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mycrudapplication.model.Employee;
import com.example.mycrudapplication.repository.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;
    
    

    @GetMapping
    public String showEmployeeList(Model model) {
        List<Employee> employees = repo.findAll();
        model.addAttribute("employees", employees);
        return "employee"; 
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee"; 
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "add_employee";
        }
        repo.save(employee);
        return "redirect:/employees"; 
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Employee> optionalEmployee = repo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "edit_employee"; 
        } else {
            
            return "redirect:/employees";
        }
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, @Valid @ModelAttribute Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_employee";
        }

        Employee existingEmployee = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        repo.save(existingEmployee);
        return "redirect:/employees"; 
    }
    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/employees"; 
}

}
