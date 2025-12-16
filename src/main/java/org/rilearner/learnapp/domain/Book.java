package org.rilearner.learnapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Book {
    @Id String name;
    String author;
    LocalDate publishedOn;
}
