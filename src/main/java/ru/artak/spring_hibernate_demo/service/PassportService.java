package ru.artak.spring_hibernate_demo.service;

import org.springframework.stereotype.Service;
import ru.artak.spring_hibernate_demo.model.Passport;
import ru.artak.spring_hibernate_demo.repository.PassportRepo;

@Service
public class PassportService {
    private final PassportRepo passportRepo;

    public PassportService(PassportRepo passportRepo) {
        this.passportRepo = passportRepo;
    }

    public Passport getById(Long id) {
        return passportRepo.getOne(id);
    }
}
