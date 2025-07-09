package task4.dto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ProductResponse(List<ProductDto> productDtoList) {
}
