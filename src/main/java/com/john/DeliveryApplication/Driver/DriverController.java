package com.john.DeliveryApplication.Driver;

import com.john.DeliveryApplication.Factory.DTO_Factory;
import com.john.DeliveryApplication.Item.ItemService;
import com.john.DeliveryApplication.RequestObjects.AssignRouteRequestBody;
import com.john.DeliveryApplication.Route.RouteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/driver")
public class DriverController {
    private final DriverService driverService;
    private final DTO_Factory dto_factory;
    @PostMapping(path = "/assign_route")
    public DriverDTO assignRoute(@RequestBody AssignRouteRequestBody request){
        return dto_factory.create(driverService.assignRoute(request.getDriverId(),request.getRouteId()));
    }
}
