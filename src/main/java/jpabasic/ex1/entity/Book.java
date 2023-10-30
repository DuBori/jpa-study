package jpabasic.ex1.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "B")
public class Book extends Item{
    private String author;
    private String isbn;
}
