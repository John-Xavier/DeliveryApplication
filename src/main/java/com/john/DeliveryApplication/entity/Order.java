package com.john.DeliveryApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "item_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate orderDate;
    private String orderStatus;
//    @OneToMany(mappedBy = "id")
//    @OrderBy(value = "id")
//    private List<Item> items;

//    @ManyToOne
//    @JoinColumn(name = "item_id", nullable = false)
//    private Item item;

    @OneToMany(mappedBy = "order")
    @OrderBy(value = "id")
    private List<OrderAudit> orderAudits;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
