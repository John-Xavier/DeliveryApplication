package com.john.DeliveryApplication.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
public class CustomerDTO {
    private final int id;
    private final String fullName;
    private final String houseNumber;
    private final String street;
    private final String town;
    private final String postcode;
}
