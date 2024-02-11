package org.example.service;
import lombok.AllArgsConstructor;
import org.example.dto.OrderDetailDTO;
import org.example.entity.Customer;
import org.example.entity.OrderDetail;
import org.example.entity.Orders;
import org.example.entity.Product;
import org.example.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderService orderService;
    private final ProductService productService;
    public OrderDetail create(OrderDetailDTO dto) {
        Orders orders = orderService.findById(dto.getOrderId());
        Product product = productService.findById(dto.getProductId());
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(orders);
        orderDetail.setProduct(product);
        orderDetail.setPrice(dto.getPrice());
        orderDetail.setQuantity(dto.getQuantity());
        return orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetail> readAll() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail update(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public void delete(Long id) {
        orderDetailRepository.deleteById(id);
    }

    public OrderDetail findById(Long id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDetail not found with id: " + id));
    }
    public List<OrderDetail> findByOrderId(Long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }
}
