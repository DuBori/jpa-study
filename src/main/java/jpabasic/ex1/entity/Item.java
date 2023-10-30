package jpabasic.ex1.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class Item extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String name;
    private int price;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;
    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categories = new ArrayList<>();

}
