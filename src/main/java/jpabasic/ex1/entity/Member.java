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
    @Embedded
    private Period period;
    @Embedded
    private Address address;

//    @OneToOne
//    @JoinColumn(name = "LOCK_ID")
//    private Locker locker;

    public Member() {
        name = DUMMY;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public Member(Period period, Address address) {
        this.name = DUMMY;
        this.period = period;
        this.address = address;
    }
}
