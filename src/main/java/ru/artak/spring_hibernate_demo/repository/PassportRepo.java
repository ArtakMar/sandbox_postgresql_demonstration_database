package ru.artak.spring_hibernate_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artak.spring_hibernate_demo.model.Passport;

public interface PassportRepo extends JpaRepository<Passport, Long> {
}
