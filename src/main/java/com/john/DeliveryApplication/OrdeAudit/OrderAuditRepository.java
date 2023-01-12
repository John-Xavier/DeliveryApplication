package com.john.DeliveryApplication.OrdeAudit;


import com.john.DeliveryApplication.entity.Order;
import com.john.DeliveryApplication.entity.OrderAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderAuditRepository extends JpaRepository<OrderAudit,Integer> {
    List<OrderAudit> findOrderAuditByorder_id(int orderId);
}
