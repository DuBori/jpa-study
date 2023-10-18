package jpabasic.ex1.entity;

import jpabasic.ex1.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/*
    테이블 이름과 Entity의 이름이 동일한건 관례
    테이블의 이름과 Entity의 이름을 다르게 가져갈 때
    -> @Table 이용해서 Member라는 Entity로 DB 테이블 USER 명시
        -> @Table(name="USER")
    테이블 컬럼과 객체의 컬럼의 이름이 동일한것도 관례
    다르다면, @Column(name="user_name") 이런식으로 매핑
* */
@Entity /*JPA 관리, 엔티티 */
@Getter /*final class, enum, inteface, inner classs 또한 사용 불가*/
@AllArgsConstructor
@NoArgsConstructor /*JPA 필수 */
@ToString
/*@Table(name = "MBR")*/
public class Member {
    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    /*
        Enum에 매칭되는 Enum 이름 저장
        ORDINAL은 DB에 매칭 INDEX 저장 사용 x
    */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    /*default*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    // varchar을 벗어난 크기에 영역을 컬럼에 사이즈를 원할 떄
    @Lob
    private String description;
    /*
    * 별도로 사용하는 db에 저장하고 싶지 않을 때
    * */
    @Transient
    private int temp;

    public void updateName(String name) {
        this.username = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return Objects.equals(getId(), member.getId()) && Objects.equals(getUsername(), member.getUsername()) && Objects.equals(getAge(), member.getAge()) && getRoleType() == member.getRoleType() && Objects.equals(getCreatedDate(), member.getCreatedDate()) && Objects.equals(getLastModifiedDate(), member.getLastModifiedDate()) && Objects.equals(getDescription(), member.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getAge(), getRoleType(), getCreatedDate(), getLastModifiedDate(), getDescription());
    }
}
