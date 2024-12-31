package za.co.speedoh.service;

import org.springframework.stereotype.Service;
import za.co.speedoh.repository.DriverRepo;

@Service
public class DriverService {
    private final DriverRepo driverRepo;

    public DriverService(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }
}
