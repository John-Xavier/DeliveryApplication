package com.john.DeliveryApplication.Order;

import com.john.DeliveryApplication.Customer.CustomerDTO;
import com.john.DeliveryApplication.Customer.CustomerService;
import com.john.DeliveryApplication.Factory.DTO_Factory;
import com.john.DeliveryApplication.Item.ItemDTO;
import com.john.DeliveryApplication.Item.ItemService;
import com.john.DeliveryApplication.OrdeAudit.OrderAuditService;
import com.john.DeliveryApplication.RequestObjects.CreateOrderRequestBody;
import com.john.DeliveryApplication.entity.Customer;
import com.john.DeliveryApplication.entity.Item;
import com.john.DeliveryApplication.entity.Order;
import com.john.DeliveryApplication.entity.OrderAudit;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderAuditService orderAuditService;
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

    @GetMapping(path = "/all/{id}")
    public List<OrderDTO> getOrderList(@PathVariable int id)
    {
        return orderService
                .getOrderList(id)
                .stream()
                .map( e -> dto_factory.create(e,
                        getCustomerDto(e.getCustomer()
                        .getId()),
                        getItemDtos(getItemIdsFromOrder(e))))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @GetMapping(path = "/cancel_order/{id}")
    public OrderDTO cancelOrder(@PathVariable int id)
    {
        Order order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        List<ItemDTO> itms = getItemDtos(getItemIdsFromOrder(order));
        return dto_factory.create(orderService.changeOrderStatus(id,"Cancelled"),cus,itms);
    }

    @GetMapping(path = "/return_order/{id}")
    public OrderDTO returnOrder(@PathVariable int id)
    {
        Order order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        List<ItemDTO> itms = getItemDtos(getItemIdsFromOrder(order));
        return dto_factory.create(orderService.changeOrderStatus(id,"ReturnPending"),cus,itms);
    }

    @GetMapping(path = "/order_returned/{id}")
    public OrderDTO orderReturned(@PathVariable int id)
    {
        Order order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        List<ItemDTO> itms = getItemDtos(getItemIdsFromOrder(order));
        return dto_factory.create(orderService.changeOrderStatus(id,"OrderReturned"),cus,itms);
    }

    @GetMapping(path = "/order_delivered/{id}")
    public OrderDTO orderDelivered(@PathVariable int id)
    {
        Order order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        List<ItemDTO> itms = getItemDtos(getItemIdsFromOrder(order));
        return dto_factory.create(orderService.changeOrderStatus(id,"OrderDelivered"),cus,itms);
    }

    @GetMapping(path = "/pick_up_order/{id}")
    public OrderDTO pickUpOrder(@PathVariable int id)
    {
        Order order = orderService.getOrder(id);
        CustomerDTO cus = getCustomerDto(order.getCustomer().getId());
        List<ItemDTO> itms = getItemDtos(getItemIdsFromOrder(order));
        return dto_factory.create(orderService.changeOrderStatus(id,"OrderPickedUp"),cus,itms);
    }

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
    List<Integer> getItemIdsFromOrder(Order order){
        List<OrderAudit> oas = orderAuditService.getItemList(order.getId());
        List<Integer> itemIds = new ArrayList<>();
        for(OrderAudit oa:oas){
            itemIds.add(oa.getItemId());
        }
        return  itemIds;
    }


}
