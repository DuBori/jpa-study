package jpabasic.ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@RequiredArgsConstructor
public class Member extends BaseEntity{
    public static final String DUMMY = "아무개";
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(nullable = false)
    private final String name;
    @Embedded
    private Address address;

    public Member() {
        name = DUMMY;
    }

}
