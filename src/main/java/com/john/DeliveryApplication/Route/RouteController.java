package com.john.DeliveryApplication.Route;

import com.john.DeliveryApplication.Factory.DTO_Factory;
import com.john.DeliveryApplication.Item.ItemDTO;
import com.john.DeliveryApplication.Item.ItemService;
import com.john.DeliveryApplication.Order.OrderDTO;
import com.john.DeliveryApplication.RequestObjects.AssignRouteRequestBody;
import com.john.DeliveryApplication.RequestObjects.CreateOrderRequestBody;
import com.john.DeliveryApplication.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/route")
public class RouteController {

    private final RouteService routeService;
    private final DTO_Factory dto_factory;

    @PostMapping(path = "/add")
    public RouteDTO createRoute(@RequestBody RouteDTO route){
        return dto_factory.create(routeService.createRoute(route),null);
    }


}
