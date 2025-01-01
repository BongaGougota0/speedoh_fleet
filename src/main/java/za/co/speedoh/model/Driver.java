package za.co.speedoh.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "driver")
public class Driver extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long driverId;
    private String driverName;
    private String driverLicense;
    private String driverPhone;
    private String driverEmail;
    private String password;
    private String driverAddress;
    private String driverLicenseImage;
    private String driverImage;
}
