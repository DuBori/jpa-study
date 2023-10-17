package jpabasic.ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*
    테이블 이름과 Entity의 이름이 동일한건 관례
    테이블의 이름과 Entity의 이름을 다르게 가져갈 때
    -> @Table 이용해서 Member라는 Entity로 DB 테이블 USER 명시
        -> @Table(name="USER")
    테이블 컬럼과 객체의 컬럼의 이름이 동일한것도 관례
    다르다면, @Column(name="user_name") 이런식으로 매핑
* */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id

    private Long id;

    private String name;

}
