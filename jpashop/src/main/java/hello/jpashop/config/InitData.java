package hello.jpashop.config;

import hello.jpashop.model.delivery.domain.Delivery;
import hello.jpashop.model.delivery.domain.DeliveryStatus;
import hello.jpashop.model.item.domain.Book;
import hello.jpashop.model.item.repository.ItemRepository;
import hello.jpashop.model.member.domain.Member;
import hello.jpashop.model.member.domain.vo.Address;
import hello.jpashop.model.member.repository.MemberRepository;
import hello.jpashop.model.order.domain.Order;
import hello.jpashop.model.order.repository.OrderRepository;
import hello.jpashop.model.orderitem.domain.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class InitData {

    private final EntityManager em;

    @EventListener(ApplicationReadyEvent.class)
    public void initData1() {
        Member member = new Member("홍길동", new Address("서울", "종로", "123123"));
        em.persist(member);

        Book book1 = Book.builder()
                .name("JPA BOOK1")
                .price(10000)
                .stockQuantity(200)
                .author("하하하")
                .isbn(123123)
                .build();

        em.persist(book1);

        Book book2 = Book.builder()
                .name("JPA BOOK2")
                .price(20000)
                .stockQuantity(300)
                .author("나나나")
                .isbn(123123)
                .build();

        em.persist(book2);

        OrderItem orderItem1 = OrderItem.createOrderItem(book1, book1.getPrice(), 10);
        OrderItem orderItem2 = OrderItem.createOrderItem(book2, book2.getPrice(), 20);

        List<OrderItem> orderItems = Arrays.asList(orderItem1, orderItem2);

        Delivery delivery = Delivery.builder()
                .address(member.getAddress())
                .status(DeliveryStatus.READY)
                .build();


        Order order = Order.createOrder(member, delivery, orderItems);
        em.persist(order);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initData2() {
        Member member = new Member("김나박이", new Address("전주", "평화로", "123123"));
        em.persist(member);

        Book book1 = Book.builder()
                .name("SPRING BOOK1")
                .price(10000)
                .stockQuantity(200)
                .author("하하하")
                .isbn(123123)
                .build();

        em.persist(book1);

        Book book2 = Book.builder()
                .name("SPRING BOOK2")
                .price(20000)
                .stockQuantity(300)
                .author("나나나")
                .isbn(123123)
                .build();

        em.persist(book2);

        OrderItem orderItem1 = OrderItem.createOrderItem(book1, book1.getPrice(), 30);
        OrderItem orderItem2 = OrderItem.createOrderItem(book2, book2.getPrice(), 40);

        List<OrderItem> orderItems = Arrays.asList(orderItem1, orderItem2);

        Delivery delivery = Delivery.builder()
                .address(member.getAddress())
                .status(DeliveryStatus.READY)
                .build();


        Order order = Order.createOrder(member, delivery, orderItems);
        em.persist(order);
    }
}
