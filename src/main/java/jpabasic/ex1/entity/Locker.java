package jpabasic.ex1.entity;

import lombok.Getter;

import javax.persistence.*;

/*@Entity*/
@Getter
public class Locker {
    @Id
    @GeneratedValue
    @Column(name = "LOCK_ID")
    private Long id;
    private String name;
    @OneToOne(mappedBy = "locker")
    private Member member;

}
