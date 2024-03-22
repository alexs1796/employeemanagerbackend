package com.example.employeemanagerf.service;


import com.example.employeemanagerf.data.EmployeeItemData;
import com.example.employeemanagerf.entity.Employee;
import com.example.employeemanagerf.exception.EmplyeeNotFoundException;
import com.example.employeemanagerf.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeItemData> findAllEmployees() {
        List<EmployeeItemData> result = new ArrayList<>();
        List<Employee> allEmplyoees = employeeRepository.findAll();
        allEmplyoees.stream().forEach((employee -> {
            EmployeeItemData employeeItemData = new EmployeeItemData();
            employeeItemData.setId(employee.getId());
            employeeItemData.setEmployeeCode(employee.getEmployeeCode());
            employeeItemData.setEmail(employee.getEmail());
            employeeItemData.setImageUrl(employee.getImageUrl());
            employeeItemData.setJobTitle(employee.getJobTitle());
            employeeItemData.setPhoneNumber(employee.getPhoneNumber());

            result.add(employeeItemData);
        }));
        return result;
    }

    @Override
    public void addEmployee(EmployeeItemData employee) {
        Employee employeeToAdd = new Employee();
        employeeToAdd.setEmployeeCode(employee.getEmployeeCode());
        employeeToAdd.setEmail(employee.getEmail());
        employeeToAdd.setId(employee.getId());
        employeeToAdd.setEmployeeCode(UUID.randomUUID().toString());
        employeeToAdd.setImageUrl(employee.getImageUrl());
        employeeToAdd.setJobTitle(employeeToAdd.getJobTitle());
        employeeToAdd.setName(employee.getName());

        employeeRepository.save(employeeToAdd);
    }

    @Override
    public void updateEmplyee(EmployeeItemData employee) {
        Employee employeeToAdd = new Employee();
        employeeToAdd.setEmployeeCode(employee.getEmployeeCode());
        employeeToAdd.setEmail(employee.getEmail());
        employeeToAdd.setId(employee.getId());
        employeeToAdd.setEmployeeCode(employee.getEmployeeCode());
        employeeToAdd.setImageUrl(employee.getImageUrl());
        employeeToAdd.setJobTitle(employeeToAdd.getJobTitle());
        employeeToAdd.setName(employee.getName());

        employeeRepository.save(employeeToAdd);
    }

    @Override
    public EmployeeItemData findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmplyeeNotFoundException("User by id" + id + "was not found")
        );

        EmployeeItemData employeeItemData = new EmployeeItemData();
        employeeItemData.setPhoneNumber(employee.getPhoneNumber());
        employeeItemData.setEmployeeCode(employee.getEmployeeCode());
        employeeItemData.setEmail(employee.getEmail());
        employeeItemData.setId(employee.getId());
        employeeItemData.setName(employee.getName());
        employeeItemData.setJobTitle(employee.getJobTitle());
        employeeItemData.setImageUrl(employee.getImageUrl());

        return employeeItemData;
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
