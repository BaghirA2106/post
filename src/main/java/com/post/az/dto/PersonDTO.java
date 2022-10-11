package com.post.az.dto;

import lombok.*;

import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private String name;
    private String surname;
    private String age;
}
