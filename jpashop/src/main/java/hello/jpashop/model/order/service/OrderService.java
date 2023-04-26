package hello.jpashop.model.order.service;

import hello.jpashop.model.delivery.domain.Delivery;
import hello.jpashop.model.item.domain.Item;
import hello.jpashop.model.item.repository.ItemRepository;
import hello.jpashop.model.member.domain.Member;
import hello.jpashop.model.member.repository.MemberRepository;
import hello.jpashop.model.order.domain.Order;
import hello.jpashop.model.order.domain.OrderSearch;
import hello.jpashop.model.order.repository.OrderRepository;
import hello.jpashop.model.orderitem.domain.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        Member member = memberRepository.findById(memberId);
        Item item = itemRepository.findById(itemId);

        Delivery delivery = Delivery.builder()
                .address(member.getAddress())
                .build();

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.createOrder(member, delivery, Arrays.asList(orderItem));

        orderRepository.save(order);

        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {

        Order order = orderRepository.findById(orderId);
        order.cancel();
    }

    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
}
