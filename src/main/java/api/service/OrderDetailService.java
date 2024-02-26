package api.service;

import api.entity.Orders;
import api.dto.OrderDetailDTO;
import api.entity.OrderDetail;
import api.entity.Product;
import api.mapper.OrderDetailMapper;
import api.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
        orderDetail.setPrice(orderDetail.getPrice());
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
