package com.capgemini.wsb.fitnesstracker.user.internal;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;

import java.time.LocalDate;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public record UserDto(@Nullable Long Id, String firstName, String lastName,
                      @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                      String email) {



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }
}
