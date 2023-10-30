package jpabasic.ex1.entity;

import lombok.Getter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorColumn(name = "A")
public class Album extends Item{

    private String author;

}
