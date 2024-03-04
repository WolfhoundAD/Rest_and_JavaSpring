package ru.shop.shoppingcart.service;

import ru.shop.shoppingcart.entity.Orders;
import ru.shop.shoppingcart.dto.OrderDetailDTO;
import ru.shop.shoppingcart.entity.OrderDetail;
import ru.shop.shoppingcart.entity.Product;
import ru.shop.shoppingcart.mapper.OrderDetailMapper;
import ru.shop.shoppingcart.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderService orderService;
    private final ProductService productService;

    public OrderDetail create(OrderDetailDTO dto) {
        OrderDetail orderDetail = OrderDetailMapper.INSTANCE.orderDetailDTOToOrderDetail(dto);
        Orders orders = orderService.findById(dto.getOrderId());
        Product product = productService.findById(dto.getProductId());
        orderDetail.setOrder(orders);
        orderDetail.setProduct(product);
        orderDetail.setPrice(dto.getPrice());
        return orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetail> readAll() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail update(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public void delete(Long id) {
        try {
            orderDetailRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete order detail with id: " + id, e);
        }
    }

    public OrderDetail findById(Long id) {
        try {
            Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
            return orderDetail.orElseThrow(() -> new RuntimeException("OrderDetail not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Failed to find order detail with id: " + id, e);
        }
    }

    public List<OrderDetail> findByOrderId(Long orderId) {
        try {
            return orderDetailRepository.findByOrderId(orderId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find order details with orderId: " + orderId, e);
        }
    }
}
