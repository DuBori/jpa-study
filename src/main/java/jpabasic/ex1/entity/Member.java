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
@SequenceGenerator(name = "member_seq_generator",
        sequenceName = "member_seq",
        initialValue = 1,
        allocationSize = 50)
public class Member {
    //    pk 자동 할당
    @Id
    //Auto db 관련 시퀀스 알아서 맞춰줌
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "member_seq_generator")
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;


    public void updateName(String name) {
        this.username = name;
    }


}
