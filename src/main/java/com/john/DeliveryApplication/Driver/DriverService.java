package com.john.DeliveryApplication.Driver;

import com.john.DeliveryApplication.Route.RouteRepository;
import com.john.DeliveryApplication.entity.Customer;
import com.john.DeliveryApplication.entity.Driver;
import com.john.DeliveryApplication.entity.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final RouteRepository routeRepository;
    public Driver assignRoute(int driverId, int routeId){
        Optional<Route> routeOptional = routeRepository.findById(routeId);
        Optional<Driver> driverOptional = (driverRepository.findById(driverId));
        if(routeOptional.isPresent()&& driverOptional.isPresent()){
            Route route = routeOptional.get();
            Driver driver = driverOptional.get();
            route.setDriver(driver);
            routeRepository.save(route);
            return (driverRepository.findById(driverId)).get();
        }
        return null;

    }

}
