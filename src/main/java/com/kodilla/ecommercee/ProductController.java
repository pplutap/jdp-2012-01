package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {
    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(Long productId) {
        return new ProductDto(1L, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(Long productId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(ProductDto productDto) {
        return new ProductDto(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(ProductDto productDto) {

    }
}
