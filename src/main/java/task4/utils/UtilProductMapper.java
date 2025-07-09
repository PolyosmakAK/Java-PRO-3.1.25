package task4.utils;

import org.springframework.stereotype.Service;
import task4.dto.ProductDto;
import task4.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilProductMapper {
    public List<ProductDto> productDtoList(List<Product> productList) {
        return productList.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    private ProductDto mapEntityToDto(Product product) {
        return new ProductDto(product.getId(), product.getAccountNumber(), product.getBalance(),
                product.getProductType(), product.getUser().getId());
    }
}
