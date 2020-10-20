package ru.artak.spring_hibernate_demo.service;

import org.springframework.stereotype.Service;
import ru.artak.spring_hibernate_demo.model.Employee;
import ru.artak.spring_hibernate_demo.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getById(Long id){
        return employeeRepository.getOne(id);
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public void  delete(Long id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

}
