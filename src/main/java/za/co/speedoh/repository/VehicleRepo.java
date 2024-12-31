package za.co.speedoh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.speedoh.model.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    Vehicle findVehicleByVehicleNumber(String vehicleNumber);
}
