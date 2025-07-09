package task4.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task4.dto.ProductResponse;
import task4.service.ProductService;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductsController {
    public final ProductService productService;

    @GetMapping(path = "userId/{id}")
    public ProductResponse getAllProductsByUserId(@PathVariable("id") Long id) {
        return productService.getAllProductsByUserId(id);
    }

    @GetMapping(path = "productId/{id}")
    public ProductResponse getProductsById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
}
