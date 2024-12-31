package za.co.speedoh.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drivers")
public class Driver extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    public Long driverId;
    public String driverName;
    public String driverLicense;
    public String driverPhone;
    public String driverEmail;
    public String password;
    public String driverAddress;
    public String driverLicenseImage;
    public String driverImage;
}
