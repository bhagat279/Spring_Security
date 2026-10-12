package com.employee_service.service;

import com.employee_service.entity.Employee;
import com.employee_service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee update(Long id, Employee employee) {

        Employee dbEmployee = findById(id);

        dbEmployee.setName(employee.getName());
        dbEmployee.setDepartment(employee.getDepartment());
        dbEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(dbEmployee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}