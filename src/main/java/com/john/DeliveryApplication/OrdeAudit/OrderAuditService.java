package com.john.DeliveryApplication.OrdeAudit;

import com.john.DeliveryApplication.Item.ItemRepository;
import com.john.DeliveryApplication.entity.Item;
import com.john.DeliveryApplication.entity.OrderAudit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class OrderAuditService {

    private final OrderAuditRepository orderAuditRepository;

    public List<OrderAudit> getItemList(int order_id)
    {
        return orderAuditRepository.findOrderAuditByorder_id(order_id);
    }
}
