package shop.repository;

import org.springframework.data.repository.CrudRepository;

import shop.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
