package ru.shop.shoppingcart.controller.v1;

import org.springframework.data.domain.Pageable;
import ru.shop.shoppingcart.entity.OrderDetail;
import ru.shop.shoppingcart.service.OrderDetailService;
import ru.shop.shoppingcart.dto.OrderDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-details")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping("/")
    public ResponseEntity<OrderDetail> create(@RequestBody OrderDetailDTO dto) {
        return ResponseEntity.ok(orderDetailService.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDetail>> readAll(Pageable pageable) {
        return ResponseEntity.ok(orderDetailService.readAll());
    }
    @PutMapping("/")
    public ResponseEntity<OrderDetail> update(@RequestBody OrderDetail orderDetail) {
        return ResponseEntity.ok(orderDetailService.update(orderDetail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderDetailService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderDetailService.findById(id));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderDetail>> findByOrderId(@PathVariable Long orderId) {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(orderId);
        return ResponseEntity.ok(orderDetails);
    }
}