package jpabasic.ex1.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item itemId;
    private int orderPrice;
    private int count;

    public void setOrder(Order order) {
        this.order = order;
    }
}
