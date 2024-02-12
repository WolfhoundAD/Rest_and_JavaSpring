package org.example.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDetailDTO;
import org.example.entity.OrderDetail;
import org.example.service.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetail> create(@RequestBody OrderDetailDTO dto) {
        return mappingResponseOrderDetail(orderDetailService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> readAll() {
        return mappingResponseListOrderDetail(orderDetailService.readAll());
    }

    @PutMapping
    public ResponseEntity<OrderDetail> update(@RequestBody OrderDetail orderDetail) {
        return mappingResponseOrderDetail(orderDetailService.update(orderDetail));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        orderDetailService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> findById(@PathVariable Long id) {
        return mappingResponseOrderDetail(orderDetailService.findById(id));
    }

    private ResponseEntity<OrderDetail> mappingResponseOrderDetail(OrderDetail orderDetail) {
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }

    private ResponseEntity<List<OrderDetail>> mappingResponseListOrderDetail(List<OrderDetail> orderDetails) {
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderDetail>> findByOrderId(@PathVariable Long orderId) {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(orderId);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }
}