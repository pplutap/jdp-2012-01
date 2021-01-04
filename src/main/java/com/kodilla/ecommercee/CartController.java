package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CartDto createCart(CartDto cartDto) {
        return new CartDto(1L, "kurtka zimowa", "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus lorem non auctor. Vivamus erat turpis, molestie a nisl non, scelerisque luctus enim. Nunc mi mi, laoreet ac mollis nec, pharetra sit amet tortor. Vivamus a bibendum purusa.", 100L, "1" );
    }

    @RequestMapping(method = RequestMethod.GET, value = "getEmptyCart")
    public List getEmptyCart() {
        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addToCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addToCart(CartDto cartDto, ProductDto productDto) {
        cartDto.add(productDto);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFromCart")
    public void deleteFromCart(CartDto cartDto, ProductDto productDto) {
        cartDto.delete(productDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(CartDto cartDto) {
        return new OrderDto(1L, "test New Order", null);
    }
}