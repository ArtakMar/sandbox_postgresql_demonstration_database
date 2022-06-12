package ru.artak.spring_hibernate_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artak.spring_hibernate_demo.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
