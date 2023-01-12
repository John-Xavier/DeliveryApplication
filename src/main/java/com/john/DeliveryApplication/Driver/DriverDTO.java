package com.john.DeliveryApplication.Driver;

import com.john.DeliveryApplication.Route.RouteDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class DriverDTO {
    private final int id;
    private final String driverName;
    private final String driverPhoneNumber;
    private final List<RouteDTO> routes;
}
