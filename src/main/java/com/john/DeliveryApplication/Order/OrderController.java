package com.john.DeliveryApplication.Order;

import com.john.DeliveryApplication.Customer.CustomerDTO;
import com.john.DeliveryApplication.Customer.CustomerService;
import com.john.DeliveryApplication.Factory.DTO_Factory;
import com.john.DeliveryApplication.Item.ItemDTO;
import com.john.DeliveryApplication.Item.ItemService;
import com.john.DeliveryApplication.RequestObjects.CreateOrderRequestBody;
import com.john.DeliveryApplication.entity.Customer;
import com.john.DeliveryApplication.entity.Item;
import com.john.DeliveryApplication.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final ItemService itemService;
    private final DTO_Factory dto_factory;

    @PostMapping(path = "/create_order")
    public OrderDTO createOrder(@RequestBody CreateOrderRequestBody requestBody){
        int customerId = requestBody.getCustomerId();
        List<Integer> itemIds = requestBody.getItemIds();

        Order order = orderService.createOrder(itemIds,customerId);
        if (order != null){
            System.out.println("Order created successfully");
            return dto_factory.create(order,getCustomerDto(customerId),getItemDtos(itemIds));
        }
        return  null;
    }
/*
    @GetMapping(path = "/all/{id}")
    public List<OrderDTO> getOrderList(@PathVariable int id)
    {
        return orderService
                .getOrderList(id)
                .stream()
                .map(e -> dto_factory.create(e,getCustomerDto(e.getCustomer().getId()),getItemDto(e.getItem().getId())))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @GetMapping(path = "/cancel_order/{id}")
    public OrderDTO cancelOrder(@PathVariable int id)
    {
        ItemOrder order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        ItemDTO itm = getItemDto(order.getItem().getId());
        return dto_factory.create(orderService.changeOrderStatus(id,"Cancelled"),cus,itm);
    }

    @GetMapping(path = "/return_order/{id}")
    public OrderDTO returnOrder(@PathVariable int id)
    {
        ItemOrder order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        ItemDTO itm = getItemDto(order.getItem().getId());
        return dto_factory.create(orderService.changeOrderStatus(id,"ReturnPending"),cus,itm);
    }

    @GetMapping(path = "/order_returned/{id}")
    public OrderDTO orderReturned(@PathVariable int id)
    {
        ItemOrder order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        ItemDTO itm = getItemDto(order.getItem().getId());
        return dto_factory.create(orderService.changeOrderStatus(id,"OrderReturned"),cus,itm);
    }

    @GetMapping(path = "/order_delivered/{id}")
    public OrderDTO orderDelivered(@PathVariable int id)
    {
        ItemOrder order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        ItemDTO itm = getItemDto(order.getItem().getId());
        return dto_factory.create(orderService.changeOrderStatus(id,"OrderDelivered"),cus,itm);
    }

    @GetMapping(path = "/pick_up_order/{id}")
    public OrderDTO pickUpOrder(@PathVariable int id)
    {
        ItemOrder order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        ItemDTO itm = getItemDto(order.getItem().getId());
        return dto_factory.create(orderService.changeOrderStatus(id,"OrderPickedUp"),cus,itm);
    }
*/
    private CustomerDTO getCustomerDto(int id){
     Customer customerEntity = customerService.getCustomer(id);
     return  dto_factory.create(customerEntity);
    }

    private List<ItemDTO> getItemDtos(List<Integer> ids){
        List<ItemDTO> items = new ArrayList<>();
        for(int i:ids){
            Item item = itemService.getItem(i);
            ItemDTO itemDto = dto_factory.create(item);
            items.add(itemDto);
        }
        return  items;
    }


}
