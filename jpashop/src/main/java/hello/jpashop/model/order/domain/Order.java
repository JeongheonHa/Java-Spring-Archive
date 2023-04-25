package hello.jpashop.model.order.domain;

import hello.jpashop.model.delivery.domain.Delivery;
import hello.jpashop.model.delivery.domain.DeliveryStatus;
import hello.jpashop.model.member.domain.Member;
import hello.jpashop.model.orderitem.domain.OrderItem;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    protected Order() {
    }

    @Builder
    private Order(Member member, Delivery delivery, OrderStatus orderStatus, LocalDateTime orderDate, List<OrderItem> orderItems) {
        this.addMember(member);
        this.addDelivery(delivery);
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        for (OrderItem orderItem : orderItems) {
            this.addOrderItem(orderItem);
        }
    }

    public void addMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.addOrder(this);
    }

    public void addDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.addOrder(this);
    }

    public static Order createOrder(Member member, Delivery delivery, List<OrderItem> orderItems) {
        return builder().member(member)
                .delivery(delivery)
                .orderItems(orderItems)
                .orderStatus(OrderStatus.ORDER)
                .orderDate(LocalDateTime.now())
                .build();
    }

    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송이 완료되어 취소가 불가합니다.");
        }

        this.orderStatus = OrderStatus.CANCEL;
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

    public int getTotalPrice() {
        return orderItems.stream()
                .mapToInt(OrderItem::getTotalPrice)
                .sum();
    }
}
