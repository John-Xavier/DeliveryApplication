package com.john.DeliveryApplication.Driver;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DriverDTO {
    private final int id;
    private final String driverName;
}
