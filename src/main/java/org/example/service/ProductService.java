package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.ProductDTO;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(ProductDTO dto) {
        return productRepository.save(Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .inStock(dto.getInStock())
                .build());
    }
    public List<Product> readAll() {
        return  productRepository.findAll();
    }
    public  Product update(Product product){
        return  productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    public List<Product> readInStockProducts() {
        return productRepository.findByInStockTrue();
    }
}

