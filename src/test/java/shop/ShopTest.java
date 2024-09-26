package shop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import shop.model.Cart;
import shop.repository.CartRepository;
import shop.service.CartService;

@SpringBootTest
class ShopTest {

	@Mock
	CartRepository cartRepository;

	@InjectMocks
	CartService cartService;

	@Test
	void contextLoads() {
	}

	@Test
	void testCartServiceFindAll() {
		Iterable<Cart> list = new ArrayList<Cart>();
		Mockito.when(cartRepository.findAll()).thenReturn(list);
		List<Cart> result = new ArrayList<Cart>();
		cartService.findAll().forEach(result::add);
		assertEquals(0, result.size());

	}

	@Test
	void testCartServiceCreate() {
		Cart cart = new Cart();
		cart.setId(100);
		Mockito.when(cartRepository.save(Mockito.any())).thenReturn(cart);
		Cart cartSaved = cartService.save(cart);
		assertEquals(100, cartSaved.getId());

	}

	@Test
	void testCartServiceFindById() {
		Optional<Cart> cart = Optional.of(new Cart());
		cart.get().setId(100);
		Mockito.when(cartRepository.findById(Mockito.any())).thenReturn(cart);
		Optional<Cart> cartSaved = cartService.findById(100);
		assertEquals(100, cartSaved.get().getId());

	}

}
