package org.example.dto;

import lombok.Data;
import org.example.entity.Product;

@Data
public class OrderDetailDTO {
    private Long orderId;
    private Long productId;
    private double price;
    private int quantity;
}
