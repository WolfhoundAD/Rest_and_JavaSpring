package ru.shop.shoppingcart.controller.v1;

import org.springframework.data.domain.Pageable;
import ru.shop.shoppingcart.dto.ProductDTO;
import ru.shop.shoppingcart.entity.Product;
import ru.shop.shoppingcart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<Stream<Product>> readAll(Pageable pageable) {
        return ResponseEntity.ok(productService.readAll());
    }
    @PutMapping("/")
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