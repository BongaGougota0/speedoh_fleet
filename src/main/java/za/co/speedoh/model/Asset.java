package za.co.speedoh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;


public class Asset{
    @CreatedDate
    LocalDateTime createdDate;
    @LastModifiedDate
    LocalDateTime lastModifiedDate;
    @LastModifiedDate
    LocalDateTime lastServiceDate;
    @JsonIgnore
    LocalDateTime nextServiceDate;
}
