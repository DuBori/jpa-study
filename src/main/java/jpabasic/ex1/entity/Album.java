package jpabasic.ex1.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@RequiredArgsConstructor
@DiscriminatorValue("A")
public class Album extends Item{

    private final String author;

    public Album() {
        author = null;
    }
}
