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
    private Period period;
    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD" ,joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID", updatable = false, insertable = false)
    private List<AddressEntity> addressEntities = new ArrayList<>();

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

    public Member(Period period, AddressEntity addressEntity) {
        this.name = DUMMY;
        this.period = period;
        this.addressEntities.add(addressEntity);
    }

    public Member(AddressEntity addressEntity) {
        this.name = DUMMY;
        this.addressEntities.add(addressEntity);
    }


    /*public void updateHomeAddress(Address address) {
        this.address = address;
    }*/
}
