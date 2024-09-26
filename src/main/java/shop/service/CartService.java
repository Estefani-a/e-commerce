package shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.model.Cart;
import shop.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	public Iterable<Cart> findAll() {
		return cartRepository.findAll();
	}

	public Cart save(Cart c) {
		return cartRepository.save(c);
	}

	public void delete(int id) {
		cartRepository.deleteById(id);
	}

	public Optional<Cart> findById(int id) {
		return cartRepository.findById(id);
	}
}
