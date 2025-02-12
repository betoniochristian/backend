package com.employeeManagement.employees.controller;

import com.employeeManagement.employees.model.Employee;
import com.employeeManagement.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeesService;

    @GetMapping
    public List<Employee> getEmployee(){
        return employeesService.getEmployee();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employees){
        return employeesService.addEmployee(employees);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employees){
        return employeesService.updateEmployee(id, employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        employeesService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

}
