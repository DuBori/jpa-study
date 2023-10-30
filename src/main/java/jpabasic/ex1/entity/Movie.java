package jpabasic.ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorColumn(name = "M")
public class Movie extends Item{
    private String director;
    private String actor;

    private String name;


}
