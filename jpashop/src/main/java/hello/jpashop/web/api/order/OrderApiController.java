package hello.jpashop.web.api.order;

import hello.jpashop.model.order.domain.Order;
import hello.jpashop.model.order.domain.OrderRequest;
import hello.jpashop.model.order.domain.OrderResponse;
import hello.jpashop.model.order.domain.OrderSearch;
import hello.jpashop.model.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;

    @GetMapping("/api/orders")
    public ResponseEntity<List<OrderResponse>> order(@Valid OrderRequest orderRequest, BindingResult bindingResult) {
        List<Order> orders = orderService.findOrders(new OrderSearch(orderRequest.getName(), orderRequest.getOrderStatus()));
        List<OrderResponse> collect = orders.stream()
                .map(o -> new OrderResponse(o))
                .collect(Collectors.toList());

        return new ResponseEntity<>(collect, HttpStatus.OK);
    }
}
