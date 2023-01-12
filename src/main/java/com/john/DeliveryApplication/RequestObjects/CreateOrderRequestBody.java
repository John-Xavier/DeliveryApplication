package com.john.DeliveryApplication.RequestObjects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class CreateOrderRequestBody {
    private final int customerId;
    private final List<Integer> itemIds;

}
