package jpabasic.ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
    private String createBy;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;
    private String lastModifyBy;

}
