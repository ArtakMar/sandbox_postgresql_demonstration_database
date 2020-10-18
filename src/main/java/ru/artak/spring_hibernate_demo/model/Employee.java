package ru.artak.spring_hibernate_demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employees_positions",
            joinColumns = @JoinColumn(name = "employeeid"),
            inverseJoinColumns = @JoinColumn(name = "positionid"))
    private List<Position> positions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee", fetch = FetchType.EAGER)
    private List<ContactDetails> items = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;


    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<ContactDetails> getItems() {
        return items;
    }

    public void setItems(List<ContactDetails> items) {
        this.items = items;
    }

    public void addContactDetails(ContactDetails contactDetails) {
        items.add(contactDetails);
        contactDetails.setEmployee(this);
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
