package com.employeeManagement.employees.service;

import com.employeeManagement.employees.model.Employee;
import com.employeeManagement.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeesRepository;

    public List<Employee> getEmployee(){
        return employeesRepository.findAll();
    }

    public Employee addEmployee(Employee employees){
        return employeesRepository.save(employees);
    }

    public Employee updateEmployee(Long id, Employee employees){
        Employee existingEmployee = employeesRepository.findById(id).orElseThrow();

        existingEmployee.setName(employees.getName());
        existingEmployee.setEmail(employees.getEmail());
        existingEmployee.setJobTitle(employees.getJobTitle());
        existingEmployee.setSalary(employees.getSalary());

        return employeesRepository.save(existingEmployee);
    }

    public void deleteEmployee (Long id){
        employeesRepository.deleteById(id);
    }

}
