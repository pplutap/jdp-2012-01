package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController {

    @GetMapping("getOrders")
    public List<CartController> getOrders() {
        return new ArrayList<>();
    }

    @PutMapping("addOrder")
    public void addOrder(OrderDto orderDto) {
        System.out.println("The order: " + orderDto + " has been added");
    }

    @GetMapping("getOrder")
    public OrderDto getOrder(Long orderId) {
        return new OrderDto(1, "Test");
    }

    @PostMapping("updateOrder")
    public OrderDto updateOrder(OrderDto orderDto) {
        return new OrderDto(1, "Test");
    }

    @DeleteMapping("deleteOrder")
    public void deleteOrder(Long orderId) {
        System.out.println("Order ID = " + orderId + " has been delete");
    }
}
