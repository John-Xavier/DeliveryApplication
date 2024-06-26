package com.john.DeliveryApplication.Factory;

import com.john.DeliveryApplication.Customer.CustomerDTO;
import com.john.DeliveryApplication.Driver.DriverDTO;
import com.john.DeliveryApplication.Item.ItemDTO;
import com.john.DeliveryApplication.Order.OrderDTO;
import com.john.DeliveryApplication.Route.RouteDTO;
import com.john.DeliveryApplication.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DTO_Factory {

    public CustomerDTO create(Customer customer){
    if (customer == null) {
            return null;
        }
        CustomerDTO customerDTO =
                new CustomerDTO(
                        customer.getId(),
                        customer.getFullName(),
                        customer.getHouseNumber(),
                        customer.getStreet(),
                        customer.getTown(),
                        customer.getPostcode());
    return customerDTO;

    }
    public ItemDTO create(Item item){
        if (item == null) {
            return null;
        }
        ItemDTO itemDTO =
                new ItemDTO(
                        item.getId(),
                        item.getItemName(),
                        item.getPrice()
                );
        return itemDTO;
    }
    public OrderDTO create(Order order, CustomerDTO customer, List<ItemDTO> items){
        if (order == null) {
            return null;
        }
//order entity do not have item array instead it have orderAudit,
// but order dto has item array because in response users can see the list of items
        OrderDTO orderDTO =
                new OrderDTO(
                        order.getId(),
                        order.getOrderStatus(),
                        order.getOrderDate(),
                        customer,
                        items
                );
        return orderDTO;
    }

    public DriverDTO create(Driver driver){
        if (driver == null) {
            return null;
        }
        DriverDTO driverDTO = new DriverDTO(
                driver.getId(),
                driver.getDriverName(),
                driver.getDriverPhoneNumber(),
                null
        );
        return driverDTO;
    }



    public RouteDTO create(Route route, Optional<DriverDTO> driverDTO){
        if (route == null) {
            return null;
        }
        RouteDTO routeDTO =
                new RouteDTO(
                        route.getId(),
                        route.getStartLocation(),
                        route.getEndLocation(),
                        route.getEstimatedTime(),
                        driverDTO
                );
        return routeDTO;
    }

}
