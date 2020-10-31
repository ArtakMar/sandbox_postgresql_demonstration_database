package ru.artak.spring_hibernate_demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passport_id_seq")
    @GenericGenerator(
            name = "passport_id_seq",
            strategy = "enhanced-sequence",
            parameters = @org.hibernate.annotations.Parameter(
                    name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "passport_id_seq"))
    private Long id;
    private String passportNumber;

    public Passport() {
    }

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Long getId() {
        return id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

}
