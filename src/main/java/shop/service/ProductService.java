package shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.model.Product;
import shop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	public Product save(Product c) {
		return productRepository.save(c);
	}

	public void delete(int id) {
		productRepository.deleteById(id);
	}

	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}

    public boolean existsById(int id) {
        return productRepository.existsById(id); // método proporcionado por JPA/Hibernate.
    }
}
