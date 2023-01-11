package com.john.DeliveryApplication.Order;

import com.john.DeliveryApplication.Customer.CustomerRepository;
import com.john.DeliveryApplication.Item.ItemRepository;
import com.john.DeliveryApplication.OrdeAudit.OrderAuditRepository;
import com.john.DeliveryApplication.entity.Customer;
import com.john.DeliveryApplication.entity.Item;
import com.john.DeliveryApplication.entity.Order;
import com.john.DeliveryApplication.entity.OrderAudit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final OrderAuditRepository orderAuditRepository;


    public Order createOrder(List<Integer> itemIds, int customerId){

//        List<Item> items = new ArrayList<>();
//        for(int i:itemIds){
//            Optional<Item> itemOptional = itemRepository.findById(i);
//            Item item = itemOptional.get();
//            items.add(item);
//        }
        Optional<Customer> customer = customerRepository.findById(customerId);
        LocalDate orderDate = LocalDate.now();
    if (customer.isPresent()) {
        System.out.printf("create order called params %d and %d",itemIds,customerId);
//create order first, leave orderAudit null
        Order o = new Order(0,
                orderDate,
                "Order Pending",
                null,
                customer.get());

        //update order audit table
        List<OrderAudit> oaList = new ArrayList<>();
        for(int itemId:itemIds){
            System.out.printf("item id:%d",itemId);
            OrderAudit oa = new OrderAudit(0,itemId,o);
           // OrderAudit orderAudit = orderAuditRepository.save(oa);
            oaList.add(oa);
        }
        System.out.printf("after saving oa list");
        //save order again
        o.setOrderAudits(oaList);
        return orderRepository.save(o);

    }
    return null;
    }

    public List<Order> getOrderList()
    {
        return orderRepository.findAll();
    }
    public List<Order> getOrderList(int customerId)
    {
        return orderRepository.findItemOrderByCustomer_Id(customerId);
    }

    public Order changeOrderStatus(int orderId, String status)
    {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if (!optionalOrder.isPresent())
        {
            return null;
        }
        Order orderEntity = optionalOrder.get();
        orderEntity.setOrderStatus(status);
        return orderRepository.save(orderEntity);
    }

    public Order getOrder(int id)
    {
        return orderRepository.findById(id).orElse(null);
    }



}
