package za.co.speedoh.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.speedoh.dto.DriverDto;
import za.co.speedoh.service.DriverService;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/drivers")
public class DriversController {
    DriverService driverService;
    public DriversController(DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDriver(@RequestBody DriverDto driverDto){
        DriverDto driverDto1 = driverService.saveDriver(driverDto);
        if(driverDto1 == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/all")
    public ResponseEntity<ArrayList<DriverDto>> getAllDrivers(){
        ArrayList<DriverDto> drivers = driverService.getAllDrivers();
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(drivers);
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable String driverId){
        DriverDto driverDto = driverService.getDriverById(driverId);
        if(driverDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(driverDto);
    }

    @PutMapping("/update")
    public ResponseEntity<DriverDto> updateDriver(@RequestBody DriverDto driverDto){
        return ResponseEntity.ok().body(driverService.updateDriver(driverDto));
    }
}
