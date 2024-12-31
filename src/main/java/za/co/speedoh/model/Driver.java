package za.co.speedoh.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "drivers")
public class Driver extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    public long driverId;
    public String driverName;
    public String driverLicense;
    public String driverPhone;
    public String driverEmail;
    public String driverAddress;
    public String driverLicenseImage;
    public String driverImage;
    public String driverLicenseImageUrl;
}
