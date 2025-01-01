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

    public DriverDto saveDriver(DriverDto driverDto){
        if(driverRepo.findDriverByDriverEmail(driverDto.driverEmail) != null){
            return null;
        }
        Driver driver = new Driver((long) (1_000_000_000L *Math.random()), driverDto.driverAddress, driverDto.driverEmail,
                driverDto.driverPhone, driverDto.driverImage, driverDto.driverLicense, driverDto.driverLicenseImage,
                driverDto.driverName, driverDto.driverPhone);
        return mapToDtos(driverRepo.save(driver));
    }

    public DriverDto getDriverById(String driverId){
        return mapToDtos(driverRepo.getOne(Long.parseLong(driverId)));
    }

    public DriverDto updateDriver(DriverDto driverDto){
        if(driverRepo.findDriverByDriverEmail(driverDto.driverEmail) == null){
            throw new RuntimeException("Driver does not exist.");
        }
        Driver driver = new Driver();
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
        return new DriverDto(driver.getDriverName(), driver.getDriverLicense(), driver.getDriverPhone(),
                driver.getDriverEmail(), driver.getDriverAddress(), driver.getDriverLicense(), driver.getDriverLicenseImage());
    }
}
