package za.co.speedoh.model;

import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class Asset{
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
    LocalDateTime lastServiceDate;
    LocalDateTime nextServiceDate;
}