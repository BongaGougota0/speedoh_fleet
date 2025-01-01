package za.co.speedoh.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class Person {
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
