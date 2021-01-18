package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private DbService dbService;
    @Autowired
    private CartMapper cartMapper;

    @RequestMapping(method = RequestMethod.POST, value = "createCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        dbService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCarts")
    public List<CartDto> getCarts() {
        List<Cart> carts = dbService.getAllCarts();
        return cartMapper.mapToCartDtoList(carts);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart(@RequestParam Long id) {
        return cartMapper.mapToCartDto(dbService.getCart(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCart")
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return cartMapper.mapToCartDto(dbService.saveCart(cartMapper.mapToCart(cartDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCart(@RequestParam Long id) {
        dbService.deleteCart(id);
    }
}