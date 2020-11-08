package ru.artak.spring_hibernate_demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artak.spring_hibernate_demo.model.Employee;
import ru.artak.spring_hibernate_demo.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getById(Long id) {
        Employee employee = employeeRepository.getOne(id);
        if (employee != null) {
            return employee;
        }
        return null;
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


}
