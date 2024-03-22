package com.example.employeemanagerf.service;

import com.example.employeemanagerf.data.EmployeeItemData;
import com.example.employeemanagerf.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeItemData> findAllEmployees();

    public void addEmployee(EmployeeItemData employee);

    public void updateEmplyee(EmployeeItemData employee);

    public void deleteEmployeeById(Long id);

    public EmployeeItemData findEmployeeById(Long id);
}
