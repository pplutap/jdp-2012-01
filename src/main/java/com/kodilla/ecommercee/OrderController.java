package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController {
    private final DbService service;
    private final OrderMapper orderMapper;

    @GetMapping("getOrders")
    public List<OrderDto> getOrders() {
        List<Order> orders = service.getAllOrders();
        return orderMapper.mapToOrderDtoList(orders);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        service.saveOrder(order);
    }

    @GetMapping("getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(
                service.getOrder(orderId).orElseThrow(OrderNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = service.saveOrder(order);
        return orderMapper.mapToOrderDto(savedOrder);
    }

    @DeleteMapping("deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        service.deleteOrder(orderId);
    }
}
