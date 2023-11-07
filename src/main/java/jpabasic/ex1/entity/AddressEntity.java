package jpabasic.ex1.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Embedded
    private Address address;

    public AddressEntity(String city, String street, String zipCode) {
        this.address = new Address(city, street, zipCode);
    }
}
