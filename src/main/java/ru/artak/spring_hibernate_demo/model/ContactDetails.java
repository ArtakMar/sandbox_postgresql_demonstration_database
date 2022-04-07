package ru.artak.spring_hibernate_demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;

@Entity
@Table(name = "contact_details")
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_details_id_seq")
    @GenericGenerator(
            name = "contact_details_id_seq",
            strategy = "enhanced-sequence",
            parameters = @org.hibernate.annotations.Parameter(
                    name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "contact_details_id_seq"))
    private Long id;
    private String email;
    private String phoneNumber;

    public ContactDetails()
    {
    }

    public ContactDetails(String email, String phoneNumber)
    {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
