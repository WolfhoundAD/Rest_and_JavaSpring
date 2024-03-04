package ru.shop.shoppingcart.service;

import ru.shop.shoppingcart.dto.ProductDTO;
import ru.shop.shoppingcart.entity.Product;
import ru.shop.shoppingcart.mapper.ProductMapper;
import ru.shop.shoppingcart.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(ProductDTO dto) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(dto);
        return productRepository.save(product);
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete product with id: " + id, e);
        }
    }

    public Product findById(Long id) {
        try {
            Optional<Product> product = productRepository.findById(id);
            return product.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Failed to find product with id: " + id, e);
        }
    }

    public List<Product> readInStockProducts() {
        return productRepository.findByInStockTrue();
    }
}

