package ru.shop.shoppingcart.controller.v1;

import ru.shop.shoppingcart.dto.ProductDTO;
import ru.shop.shoppingcart.entity.Product;
import ru.shop.shoppingcart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> readAll() {
        return ResponseEntity.ok(productService.readAll());
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/inStock")
    public ResponseEntity<List<Product>> readInStockProducts() {
        List<Product> inStockProducts = productService.readInStockProducts();
        return ResponseEntity.ok(inStockProducts);
    }
}