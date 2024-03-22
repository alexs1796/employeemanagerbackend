package com.example.employeemanagerf.controller;


import com.example.employeemanagerf.data.EmployeeItemData;
import com.example.employeemanagerf.entity.Employee;
import com.example.employeemanagerf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<EmployeeItemData>> getAllEmployees(){
        List<EmployeeItemData> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeItemData> getEmployeeById(@PathVariable Long id){
        EmployeeItemData employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody EmployeeItemData employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody EmployeeItemData employee){
        employeeService.updateEmplyee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void updateEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(Long.valueOf(id));
    }

}
