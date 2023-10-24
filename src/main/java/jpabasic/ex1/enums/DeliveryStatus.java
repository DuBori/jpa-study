package jpabasic.ex1.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeliveryStatus {
    A("발주대기"),
    B("발주준비"),
    C("출고준비"),
    D("출고완료"),
    E("배송중"),
    F("배송완료");
    private final String desc;
}
