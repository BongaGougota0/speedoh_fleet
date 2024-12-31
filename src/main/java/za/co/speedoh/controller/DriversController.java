package za.co.speedoh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.speedoh.service.DriverService;

@RestController
@RequestMapping("/api/drivers")
public class DriversController {
    DriverService driverService;
    public DriversController(DriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllDrivers(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<?> getDriverById(@PathVariable String driverId){
        return ResponseEntity.ok().build();
    }
}
