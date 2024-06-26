package com.john.DeliveryApplication.Order;

import com.john.DeliveryApplication.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findItemOrderByCustomer_Id(int customerId);
}
