package com.post.az.dto;

import lombok.*;

import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private String name;
    private String surname;
    private String age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO dto = (PersonDTO) o;
        return name.equals(dto.name) && surname.equals(dto.surname) && age.equals(dto.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
