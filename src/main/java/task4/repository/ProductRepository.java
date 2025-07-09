package task4.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task4.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @EntityGraph(value = "user.with-products")
    List<Product> getProductsByUserId(Long userId);

    @EntityGraph(value = "user.with-products")
    Product getProductsById(Long productId);
}
