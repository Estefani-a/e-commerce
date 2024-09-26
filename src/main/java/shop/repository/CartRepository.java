package shop.repository;

import org.springframework.data.repository.CrudRepository;

import shop.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

}
