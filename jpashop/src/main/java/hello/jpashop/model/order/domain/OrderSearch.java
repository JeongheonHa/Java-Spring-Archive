package hello.jpashop.model.order.domain;

import lombok.Getter;

@Getter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;

    public OrderSearch(String memberName, OrderStatus orderStatus) {
        this.memberName = memberName;
        this.orderStatus = orderStatus;
    }
}
