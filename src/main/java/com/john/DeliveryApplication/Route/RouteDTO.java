package com.john.DeliveryApplication.Route;

import com.john.DeliveryApplication.Driver.DriverDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@RequiredArgsConstructor
@Getter
public class RouteDTO {
    private final int id;
    private final String startLocation;
    private final String endLocation;
    private final String estimatedTime;
    @Setter
    private final Optional<DriverDTO> driver;

}
