package hello.jpashop.model.order.service;

import hello.jpashop.model.delivery.domain.Delivery;
import hello.jpashop.model.item.domain.Book;
import hello.jpashop.model.item.domain.Item;
import hello.jpashop.model.item.exception.NotEnoughStockException;
import hello.jpashop.model.member.domain.Member;
import hello.jpashop.model.member.domain.vo.Address;
import hello.jpashop.model.order.domain.Order;
import hello.jpashop.model.order.domain.OrderStatus;
import hello.jpashop.model.order.repository.OrderRepository;
import hello.jpashop.model.orderitem.domain.OrderItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void 상품주문() {
        //given
        Member member = createMember();
        Book book = createBook();

        int orderCount = 2;

        //when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findById(orderId);

        assertThat(getOrder.getOrderStatus()).isEqualTo(OrderStatus.ORDER);
        assertThat(getOrder.getOrderItems().size()).isEqualTo(1);
        assertThat(getOrder.getTotalPrice()).isEqualTo(10000 * orderCount);
        assertThat(book.getStockQuantity()).isEqualTo(8);
    }

    @Test
    void 상품주문_재고수량_초과() {
        //given
        Member member = createMember();
        Book book = createBook();

        int orderCount = 11;

        //when

        //then
        assertThatThrownBy(
                () -> orderService.order(member.getId(), book.getId(), orderCount)
        ).isInstanceOf(NotEnoughStockException.class);
    }

    @Test
    void 주문취소() {
        //given
        Member member = createMember();
        Book book = createBook();

        int orderCount = 2;

        //when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
        orderService.cancelOrder(orderId);

        //then
        Order getOrder = orderRepository.findById(orderId);

        assertThat(getOrder.getOrderStatus()).isEqualTo(OrderStatus.CANCEL);
        assertThat(book.getStockQuantity()).isEqualTo(10);
    }

    @Test
    void 빌더_연관관계_편의_메서드_테스트() {
        //given
        Book book = createBook();
        Member member = createMember();

        //when
        OrderItem orderItem = OrderItem.createOrderItem(book, book.getPrice(), 10);
        Order order = Order.createOrder(member, Delivery.builder().build(), Arrays.asList(orderItem));

        //then
        assertThat(order.getOrderItems().size()).isEqualTo(1);
        assertThat(orderItem.getOrder()).isEqualTo(order);
    }

    private Book createBook() {
        Book book = Book.builder().name("개미")
                .price(10000)
                .stockQuantity(10)
                .author("베르베르")
                .isbn(123123)
                .build();
        em.persist(book);
        return book;
    }

    private Member createMember() {
        Member member = new Member("회원1", new Address("서울", "종로", "123-123"));
        em.persist(member);
        return member;
    }
        
}