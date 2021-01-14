package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                userMapper.mapToUser(cartDto.getUserDto()),
                productMapper.mapToProductList(cartDto.getProductsInCart()));
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(
                cart.getId(),
                userMapper.mapToUserDto(cart.getUser()),
                productMapper.mapToProductDtoList(cart.getProductsInCart()));
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
