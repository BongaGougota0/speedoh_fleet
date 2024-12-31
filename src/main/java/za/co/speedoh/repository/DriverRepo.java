package za.co.speedoh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.speedoh.model.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Long, Driver> {
}
