package com.john.DeliveryApplication.Route;

import com.john.DeliveryApplication.Driver.DriverRepository;
import com.john.DeliveryApplication.Item.ItemDTO;
import com.john.DeliveryApplication.Item.ItemRepository;
import com.john.DeliveryApplication.entity.Driver;
import com.john.DeliveryApplication.entity.Item;
import com.john.DeliveryApplication.entity.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RouteService {
    private final RouteRepository routeRepository;
    private final DriverRepository driverRepository;

    public Route createRoute(RouteDTO routeDTO)
    {

        Route i = new Route(routeDTO.getId(),
                routeDTO.getStartLocation(),
                routeDTO.getEndLocation(),
                routeDTO.getEstimatedTime(),
                null);


        return routeRepository.save(i);

    }


}

