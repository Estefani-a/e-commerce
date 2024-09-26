package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import shop.model.Cart;
import shop.model.Product;
import shop.service.CartService;
import shop.service.ProductService;
import shop.util.Enums;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Autowired
    CartService carritoService;

    @Autowired
    ProductService productoService;

    @Override
    public void run(String... args) throws Exception {
        // creo y guardar productos
        Product prod1 = createAndSaveProduct("Webcam", 15000f);
        Product prod2 = createAndSaveProduct("Smartphone", 20000f);
        Product prod3 = createAndSaveProduct("Kindle", 10000f);

        // creo y guardar el carrito
        Cart carrito = createCart(Enums.CartType.COMUN, prod1, prod2, prod3);
        carritoService.save(carrito);
    }

    private Product createAndSaveProduct(String name, float price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return productoService.save(product);
    }

    private Cart createCart(Enums.CartType cartType, Product... products) {
        Cart cart = new Cart(cartType);
        for (Product product : products) {
            cart.getProducts().add(product);
        }
        return cart; // Devolver el carrito para que se guarde después
    }
}
