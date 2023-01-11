package com.john.DeliveryApplication.Item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ItemDTO {
    private final int id;
    private final String itemName;
    private final String price;
}
