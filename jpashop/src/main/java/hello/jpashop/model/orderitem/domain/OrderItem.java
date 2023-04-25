package hello.jpashop.model.orderitem.domain;

import hello.jpashop.model.item.domain.Item;
import hello.jpashop.model.order.domain.Order;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;

    private int count; // 주문된 아이템 수

    protected OrderItem() {
    }

    @Builder
    private OrderItem(Item item, Order order, int orderPrice, int count) {
        this.item = item;
        this.order = order;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        item.popStock(count);
        return builder()
                .item(item)
                .orderPrice(orderPrice)
                .count(count)
                .build();
    }

    public void addOrder(Order order) {
        this.order = order;
    }

    // 비즈니스 로직
    public void cancel() {
        getItem().addStock(count);
    }

    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
