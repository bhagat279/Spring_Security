package com.employee_service.service;

import com.employee_service.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(Long id);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}
