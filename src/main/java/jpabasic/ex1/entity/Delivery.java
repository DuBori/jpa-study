package jpabasic.ex1.entity;

import jpabasic.ex1.enums.DeliveryStatus;
import jpabasic.ex1.enums.OrderStatus;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;
    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String street;
    private String zipcode;
    private String city;
    private DeliveryStatus status;
}
