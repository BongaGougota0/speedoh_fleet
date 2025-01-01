package za.co.speedoh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.speedoh.dto.VehicleDto;
import za.co.speedoh.service.VehiclesService;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/vehicles")
public class VehiclesController {
    private final VehiclesService vehiclesService;
    public VehiclesController(VehiclesService vehiclesService){
        this.vehiclesService = vehiclesService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto){
        VehicleDto vehicleDto1 = vehiclesService.saveVehicle(vehicleDto);
        if(vehicleDto1 == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<VehicleDto>> getAllVehicles(){
        return ResponseEntity.ok().body(vehiclesService.getAllVechicles());
    }

    @GetMapping("/{registrationNumber}")
    public ResponseEntity<VehicleDto> getVehicleByRegistrationNumber(@PathVariable String registrationNumber){
        VehicleDto vehicleDto = vehiclesService.getVehicleByRegistrationNumber(registrationNumber);
        if(vehicleDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(vehicleDto);
    }

    @PutMapping("/update")
    public ResponseEntity<VehicleDto> updateVehicle(@RequestBody VehicleDto vehicleDto){
        VehicleDto vehicleDto1 = vehiclesService.updateVehicle(vehicleDto);
        if(vehicleDto1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(vehicleDto1);
    }

}
