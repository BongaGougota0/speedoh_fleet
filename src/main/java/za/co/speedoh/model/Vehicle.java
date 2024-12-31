package za.co.speedoh.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle extends Asset{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    public Long vehicleId;
    public String vehicleName;
    public String vehicleType;
    public String vehicleNumber;
    public String vehicleImage;
    public String vehicleImageUrl;
}
