package jpabasic.ex1.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    TOR01("결제완료"),
    TOR02("상품준비중"),
    TOR03("배송중"),
    TOR04("배송완료"),
    TOR05("구매확정"),
    TOC01("결제취소");

    private final String descFo;
}
