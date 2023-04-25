package hello.jpashop.model.delivery.domain;

import hello.jpashop.model.member.domain.vo.Address;
import hello.jpashop.model.order.domain.Order;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    protected Delivery() {
    }

    @Builder
    public Delivery(Order order, Address address, DeliveryStatus status) {
        this.order = order;
        this.address = address;
        this.status = status;
    }

    public void addOrder(Order order) {
        this.order = order;
    }
}
