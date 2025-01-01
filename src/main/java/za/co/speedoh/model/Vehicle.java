package za.co.speedoh.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity(name = "vehicle")
public class Vehicle extends Asset{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long vehicleId;
    private String vehicleName;
    private String vehicleType;
    private String vehicleNumber;
    private String vehicleImage;
    private String vehicleImageUrl;
}
