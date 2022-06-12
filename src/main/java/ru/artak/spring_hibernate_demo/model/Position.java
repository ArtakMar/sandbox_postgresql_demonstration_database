package ru.artak.spring_hibernate_demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_id_seq")
    @GenericGenerator(
            name = "position_id_seq",
            strategy = "enhanced-sequence",
            parameters = @org.hibernate.annotations.Parameter(
                    name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "position_id_seq"))
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employees_positions",
            joinColumns = @JoinColumn(name = "positionid"),
            inverseJoinColumns = @JoinColumn(name = "employeeid"))
    private List<Employee> employees = new ArrayList<>();

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



}
