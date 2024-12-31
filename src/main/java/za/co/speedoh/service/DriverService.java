package za.co.speedoh.service;

import org.springframework.stereotype.Service;
import za.co.speedoh.dto.DriverDto;
import za.co.speedoh.model.Driver;
import za.co.speedoh.repository.DriverRepo;

import java.util.ArrayList;

@Service
public class DriverService {
    private final DriverRepo driverRepo;

    public DriverService(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    public DriverDto getDriverById(String driverId){
        return mapToDtos(driverRepo.getOne(Long.parseLong(driverId)));
    }

    public DriverDto updateDriver(DriverDto driverDto){
        Driver driver = driverRepo.findDriverByDriverEmail(driverDto.driverEmail);
        if(driver == null){
            throw new RuntimeException("Driver does not exist.");
        }
        driver.setDriverAddress(driverDto.driverAddress);
        driver.setDriverEmail(driverDto.driverEmail);
        driver.setDriverImage(driverDto.driverImage);
        driver.setDriverLicense(driverDto.driverLicense);
        driver.setDriverLicenseImage(driverDto.driverLicenseImage);
        driver.setDriverName(driverDto.driverName);
        driver.setDriverPhone(driverDto.driverPhone);
        return this.mapToDtos(driverRepo.save(driver));
    }

    public ArrayList<DriverDto> getAllDrivers(){
        return driverRepo.findAll().stream().map(this::mapToDtos)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public DriverDto mapToDtos(Driver driver){
        return new DriverDto(driver.driverName, driver.driverLicense, driver.driverPhone,
                driver.driverEmail, driver.driverAddress, driver.driverLicenseImage, driver.driverImage);
    }
}
