package jpabasic.ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

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
    private String city;
    private String street;
    private String zipCode;

//    @OneToOne
//    @JoinColumn(name = "LOCK_ID")
//    private Locker locker;

    public Member() {
        name = DUMMY;
    }

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
