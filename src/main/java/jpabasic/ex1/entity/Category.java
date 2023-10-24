package jpabasic.ex1.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private String id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
}
