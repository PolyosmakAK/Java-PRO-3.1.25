package task4.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "product_type")
    private String productType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
