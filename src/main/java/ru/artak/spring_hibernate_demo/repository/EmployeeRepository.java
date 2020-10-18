package ru.artak.spring_hibernate_demo.repository;

import org.springframework.data.repository.CrudRepository;
import ru.artak.spring_hibernate_demo.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
