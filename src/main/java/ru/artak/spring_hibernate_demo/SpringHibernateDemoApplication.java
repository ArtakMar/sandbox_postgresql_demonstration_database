package ru.artak.spring_hibernate_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.artak.spring_hibernate_demo.model.ContactDetails;
import ru.artak.spring_hibernate_demo.model.Employee;
import ru.artak.spring_hibernate_demo.model.Passport;
import ru.artak.spring_hibernate_demo.model.Position;
import ru.artak.spring_hibernate_demo.repository.EmployeeRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringHibernateDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateDemoApplication.class, args);
    }

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        Employee anna = new Employee("Anna", 21);
        Employee olesya = new Employee("Olesya", 22);

        //passports
        Passport passportAnna = new Passport("A1111111");
        Passport passportOlesya = new Passport("M3333333");

        //contactDetails
        ContactDetails contactDetailsAnna = new ContactDetails("anna@mail.ru", "911-55-17");
        ContactDetails contactDetailsOlesya = new ContactDetails("olesya@mail.ru", "911-55-16");

        //position
        Position positionAnna = new Position("QA");
        Position positionAnna2 = new Position("Developer");
        Position positionOlesya = new Position("Tester");
        Position positionOlesya2 = new Position("Developer");


        anna.setPassport(passportAnna);
        olesya.setPassport(passportOlesya);

        anna.addContactDetails(contactDetailsAnna);
        olesya.addContactDetails(contactDetailsOlesya);

        anna.setPositions(Arrays.asList(positionAnna, positionAnna2));
        olesya.setPositions(Arrays.asList(positionOlesya, positionOlesya2));

        List<Employee> people = Arrays.asList(anna, olesya);

        employeeRepository.saveAll(people);


    }
}
