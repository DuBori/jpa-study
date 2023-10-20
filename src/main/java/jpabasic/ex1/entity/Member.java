package jpabasic.ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    private String city;
    private String street;
    private String zipCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(String name, String city, String street, String zipCode, Team team) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.team = team;
    }

    public void updateName(String name) {
        this.name = name;
    }


}
