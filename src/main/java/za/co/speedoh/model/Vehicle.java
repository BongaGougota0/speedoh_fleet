package za.co.speedoh.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "vehicles")
public class Vehicle extends Asset{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    public long vehicleId;
    public String vehicleName;
    public String vehicleType;
    public String vehicleNumber;
    public String vehicleImage;
    public String vehicleImageUrl;
}
