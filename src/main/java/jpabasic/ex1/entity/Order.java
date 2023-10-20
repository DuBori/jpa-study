package jpabasic.ex1.entity;

import jpabasic.ex1.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    private Long id;
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private LocalDateTime orderDate;


}
