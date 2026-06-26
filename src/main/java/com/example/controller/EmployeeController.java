package com.example.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<String> employees = new ArrayList<>();

    @PostMapping
    public String addEmployee(@RequestParam String name) {
        employees.add(name);
        return "Employee added: " + name;
    }

    @GetMapping
    public List<String> getEmployees() {
        return employees;
    }
}
