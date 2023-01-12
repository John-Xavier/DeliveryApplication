package com.john.DeliveryApplication.RequestObjects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AssignRouteRequestBody {
    private final int routeId;
    private final int driverId;
}
