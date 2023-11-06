package jpabasic.ex1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
@Embeddable
@Getter
@NoArgsConstructor
public class Period {
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public Period(LocalDateTime startAt, LocalDateTime endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }
}
