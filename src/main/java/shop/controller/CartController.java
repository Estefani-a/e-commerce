package shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shop.model.Cart;
import shop.service.CartService;
import shop.util.Enums.CartState;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CartController {

	@Autowired
	CartService cartService;

	@GetMapping("/cart/get")
	public Iterable<Cart> getAll() {
		return cartService.findAll();
	}

	@GetMapping("/cart/get/{id}")
	public Cart findById(@PathVariable int id) {
		Optional<Cart> optionalCart = cartService.findById(id);
		if (optionalCart.isPresent()) {
			return optionalCart.get();
		} else
			return null;
	}

	@PostMapping("/cart/add")
	public ResponseEntity<String> save(@RequestBody Cart c) {
        try {
            // Establece el estado a OPEN al crear el carrito
            c.setState(CartState.ABIERTO); 
            Cart newCarrito = cartService.save(c);
            String message = "Carrito creado con éxito: " + newCarrito.getId();
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMessage = "Error al crear el carrito: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

	@PutMapping("/cart/update")
	public Cart update(@RequestBody Cart c) {
		return cartService.save(c);
	}

	@DeleteMapping("/cart/delete/{id}")
	public void delete(@PathVariable int id) {
		cartService.delete(id);
	}

}
