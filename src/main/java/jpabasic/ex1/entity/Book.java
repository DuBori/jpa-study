package jpabasic.ex1.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@RequiredArgsConstructor
@DiscriminatorValue("B")
public class Book extends Item{
    private final String author;

    private final String isbn;
    public Book() {
        author = null;
        isbn = null;
    }
}
