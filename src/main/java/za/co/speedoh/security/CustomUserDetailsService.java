package za.co.speedoh.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.co.speedoh.model.Driver;
import za.co.speedoh.service.DriverService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    DriverService driverService;

    public CustomUserDetailsService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Driver driver = driverService.getDriverByDriverEmail(username);
        return null;
    }
}
