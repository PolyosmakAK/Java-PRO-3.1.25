package task4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@NamedEntityGraph(
        name = "user.with-products",
        attributeNodes = {
                @NamedAttributeNode("products")
        }
)
public class User {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Product> products;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
