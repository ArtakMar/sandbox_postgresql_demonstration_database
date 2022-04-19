package ru.artak.spring_hibernate_demo.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.artak.spring_hibernate_demo.model.Passport;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest
{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PassportRepo passportRepo;


    @Test
    void injectedComponentsAreNotNull()
    {
        List<Passport> all = passportRepo.findAll();
        assertTrue(all.isEmpty());
        Passport p = new Passport();
        p.setPassportNumber("2");
        passportRepo.save(p);

        List<Passport> all2 = passportRepo.findAll();
        assertFalse(all2.isEmpty());

    }
}