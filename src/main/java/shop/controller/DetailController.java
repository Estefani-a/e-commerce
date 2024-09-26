package shop.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shop.model.Cart;
import shop.model.Product;
import shop.service.CartService;
import shop.service.ProductService;
import shop.util.Enums.CartState;
import shop.util.FormCartProduct;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class DetailController {

    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;

    @GetMapping("/detail/{id}")
    public Set<Product> findById(@PathVariable int id) {
            Optional<Cart> optionalCart = cartService.findById(id);
            if (optionalCart.isPresent()) {
                    return optionalCart.get().getProducts();
            } else
                    return new HashSet<Product>();
    }

    @PostMapping("/detail/add")
    public ResponseEntity<?> add(@RequestBody FormCartProduct form) {
            Optional<Cart> optionalCart = cartService.findById(form.getCartId());
            if (optionalCart.isPresent()) {
                    Optional<Product> optProd = productService.findById(form.getProductId());
                    if (optProd.isPresent()) {
                            Cart cart = optionalCart.get();
                            cart.getProducts().add(optProd.get());
                            cart = cartService.save(cart);
                            return new ResponseEntity<Cart>(cart, HttpStatus.OK);
                    }
            }

            return new ResponseEntity<String>("No se pudo agregar detalle", HttpStatus.BAD_REQUEST);
    }
        
    @DeleteMapping("/detail/remove")
    public ResponseEntity<?> removeProductFromCart(@RequestBody FormCartProduct form) {
    Optional<Cart> optionalCart = cartService.findById(form.getCartId());
    if (optionalCart.isPresent()) {
        Optional<Product> optProd = productService.findById(form.getProductId());
        if (optProd.isPresent()) {
            Cart cart = optionalCart.get();
            Product productToRemove = optProd.get();
            // eliminar  el producto del carrito
            cart.getProducts().remove(productToRemove);
            cart = cartService.save(cart);
            
            // Creo un objeto para la respuesta
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Producto eliminado con éxito.");
            response.put("cart", cart);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/buy")
    public ResponseEntity<?> buy(@RequestBody FormCartProduct form) {
    Optional<Cart> optionalCart = cartService.findById(form.getCartId());
    if (optionalCart.isPresent()) {
        Cart cart = optionalCart.get();
        cart.setState(CartState.CERRADO);
        cartService.save(cart);        
        // crear un objeto para la respuesta
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Estado cambiado a cerrado correctamente.");
        response.put("cart", cart);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    return new ResponseEntity<>("Carrito no encontrado.", HttpStatus.BAD_REQUEST);
    }
}
