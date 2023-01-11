package com.john.DeliveryApplication.RequestObjects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ChangeOrderRequestBody {
    private final String orderStatus;
    private final int orderId;
}
