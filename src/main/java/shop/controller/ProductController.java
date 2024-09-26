package shop.controller;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shop.model.Product;
import shop.service.ProductService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //traigo todos los productos
    @GetMapping("/get")
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    //  producto por ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // creamos nuevo producto
    @PostMapping ("/save")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    //actualizo producto existente
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, String>> updateProduct(@PathVariable int id, @Valid @RequestBody Product product) {
    return productService.findById(id)
            .map(existingProduct -> {
                product.setId(id);  // para mantener el ID
                productService.save(product); // guardar el producto actualizado
                Map<String, String> response = new HashMap<>();
                response.put("message", "El producto fue modificado exitosamente.");
                return ResponseEntity.ok(response);
            })
            .orElseGet(() -> {
                Map<String, String> response = new HashMap<>();
                response.put("error", "Producto no encontrado.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            });
}


    // elimino producto por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
    if (productService.existsById(id)) {
        productService.delete(id);
        return ResponseEntity.ok("El producto ha sido eliminado exitosamente."); 
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Producto no encontrado."); 
    }
}
}

