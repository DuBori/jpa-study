package jpabasic.ex1.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum RoleType {
    USER("유저", "user"),
    ADMIN("관리자", "admin");

    private final String desc;
    private final String dbValue;
}
