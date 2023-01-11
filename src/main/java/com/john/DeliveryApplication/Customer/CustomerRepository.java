package com.john.DeliveryApplication.Customer;

import com.john.DeliveryApplication.entity.Customer;
import com.john.DeliveryApplication.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
