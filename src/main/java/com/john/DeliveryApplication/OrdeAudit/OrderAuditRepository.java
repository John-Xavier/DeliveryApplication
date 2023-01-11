package com.john.DeliveryApplication.OrdeAudit;


import com.john.DeliveryApplication.entity.OrderAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAuditRepository extends JpaRepository<OrderAudit,Integer> {
}
