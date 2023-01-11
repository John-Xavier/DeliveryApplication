package com.john.DeliveryApplication.Customer;

import com.john.DeliveryApplication.Item.ItemRepository;
import com.john.DeliveryApplication.entity.Customer;
import com.john.DeliveryApplication.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    public Customer getCustomer(int id)
    {
        return customerRepository.findById(id).orElse(null);
    }
}
