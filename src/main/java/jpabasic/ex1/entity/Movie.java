package jpabasic.ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@RequiredArgsConstructor
@DiscriminatorValue("M")
public class Movie extends Item{
    private final String director;
    private final String actor;

    public Movie() {
        this.director = null;
        this.actor = null;
    }
}
