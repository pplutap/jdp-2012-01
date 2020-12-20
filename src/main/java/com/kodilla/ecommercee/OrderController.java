package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(OrderDto orderDto) {
        System.out.println("The order: " + orderDto + " has been added");
    }

    @GetMapping("getOrder")
    public OrderDto getOrder(Long orderId) {
        return new OrderDto(1L, "Test");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(OrderDto orderDto) {
        return new OrderDto(1L, "Test");
    }

    @DeleteMapping("deleteOrder")
    public void deleteOrder(Long orderId) {
        System.out.println("Order ID = " + orderId + " has been delete");
    }
}
