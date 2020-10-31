package ru.artak.spring_hibernate_demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.artak.spring_hibernate_demo.model.Passport;
import ru.artak.spring_hibernate_demo.service.PassportService;

@RestController
@RequestMapping(value = "/v1/passport")
public class PassportController {
    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Passport> getPassportById(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Passport passport = this.passportService.getById(id);

        if (passport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(passport, HttpStatus.OK);
    }

}


