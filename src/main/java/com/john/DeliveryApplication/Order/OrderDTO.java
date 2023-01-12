package com.john.DeliveryApplication.Order;

import com.john.DeliveryApplication.Customer.CustomerDTO;
import com.john.DeliveryApplication.Item.ItemDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class OrderDTO {
    private final int id;
    private final String orderStatus;
    private final LocalDate orderDate;
    private final CustomerDTO customer;
    private final List<ItemDTO> items;
}
