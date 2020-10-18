package ru.artak.spring_hibernate_demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "positions")
    private List<Employee> employeeSet = new ArrayList<>();

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(List<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
