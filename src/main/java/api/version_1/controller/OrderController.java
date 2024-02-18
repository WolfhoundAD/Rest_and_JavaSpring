package api.version_1.controller;

import api.version_1.dto.OrderDTO;
import api.version_1.entity.Orders;
import api.version_1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService ordersService;

    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody OrderDTO dto) {
        return ResponseEntity.ok(ordersService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Orders>> readAll() {
        return ResponseEntity.ok(ordersService.readAll());
    }

    @PutMapping
    public ResponseEntity<Orders> update(@RequestBody Orders orders) {
        return ResponseEntity.ok(ordersService.update(orders));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        ordersService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ordersService.findById(id));
    }
}
