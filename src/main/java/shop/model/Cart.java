package shop.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import shop.util.Enums;
import shop.util.Enums.CartState;
import shop.util.Enums.CartType;
@Getter @Setter
@Entity
public class Cart {
	public Cart() {
	}

	public Cart(CartType type) {
		this.type = type;
		this.state = CartState.ABIERTO;
		this.products = new HashSet<Product>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
        @Enumerated(EnumType.STRING)
	@Column
        
        private Enums.CartType type; 
        @Enumerated(EnumType.STRING)
        @Column
        private Enums.CartState state;
	@ManyToMany
	Set<Product> products;

}
