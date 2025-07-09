package task4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import task4.dto.ProductResponse;
import task4.entity.Product;
import task4.repository.ProductRepository;
import task4.utils.UtilProductMapper;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UtilProductMapper productMapper;

    public ProductResponse getAllProductsByUserId(Long id) {
        List<Product> productList = productRepository.getProductsByUserId(id);
        return new ProductResponse(productMapper.productDtoList(productList));
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.getProductsById(id);
        return new ProductResponse(productMapper.productDtoList(Collections.singletonList(product)));
    }
}
