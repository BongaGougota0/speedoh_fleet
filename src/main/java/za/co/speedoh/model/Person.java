package za.co.speedoh.model;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public class Person {
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
}
