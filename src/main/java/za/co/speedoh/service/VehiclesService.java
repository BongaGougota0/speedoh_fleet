package za.co.speedoh.service;

import org.springframework.stereotype.Service;
import za.co.speedoh.dto.VehicleDto;
import za.co.speedoh.model.Vehicle;
import za.co.speedoh.repository.VehicleRepo;

import java.util.ArrayList;

@Service
public class VehiclesService {
    private final VehicleRepo vehicleRepo;

    public VehiclesService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public ArrayList<VehicleDto> getAllVechicles(){
        return vehicleRepo.findAll().stream().map(this::mapToDtos)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public VehicleDto mapToDtos(Vehicle vehicle){
        return new VehicleDto(vehicle.getVehicleName(), vehicle.getVehicleType(), vehicle.getVehicleNumber(),
                vehicle.getVehicleImage(), vehicle.getVehicleImageUrl());
    }

    public VehicleDto getVehicleByRegistrationNumber(String registrationNumber) {
        Vehicle vehicle = vehicleRepo.findVehicleByVehicleNumber(registrationNumber);
        if(vehicle == null){
            return null;
        }
        return mapToDtos(vehicle);
    }

    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepo.findVehicleByVehicleNumber(vehicleDto.vehicleNumber);
        if(vehicle == null){
            return null;
        }
        vehicle.setVehicleName(vehicleDto.vehicleName);
        vehicle.setVehicleType(vehicleDto.vehicleType);
        vehicle.setVehicleImage(vehicleDto.vehicleImage);
        vehicle.setVehicleImageUrl(vehicleDto.vehicleImageUrl);
//        vehicle.setVehicleNumber(vehicleDto.vehicleNumber); cant be changed.
        vehicleRepo.save(vehicle);
        return mapToDtos(vehicle);
    }
}
