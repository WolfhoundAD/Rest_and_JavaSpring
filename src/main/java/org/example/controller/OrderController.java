package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.OrderDTO;
import org.example.entity.Orders;
import org.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService ordersService;

    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody OrderDTO dto) {
        return mappingResponseOrder(ordersService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Orders>> readAll() {
        return mappingResponseListOrder(ordersService.readAll());
    }

    @PutMapping
    public ResponseEntity<Orders> update(@RequestBody Orders orders) {
        return mappingResponseOrder(ordersService.update(orders));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        ordersService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Orders> mappingResponseOrder(Orders orders) {
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    private ResponseEntity<List<Orders>> mappingResponseListOrder(List<Orders> orders) {
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Orders> findById(@PathVariable Long id) {
        return mappingResponseOrder(ordersService.findById(id));
    }
}
