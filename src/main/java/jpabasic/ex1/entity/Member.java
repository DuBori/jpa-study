package jpabasic.ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(nullable = false)
    private String name;
    private String city;
    private String street;
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "LOCK_ID")
    private Locker locker;

    public void updateName(String name) {
        this.name = name;
    }


}
