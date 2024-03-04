package ru.shop.shoppingcart.controller.v1;

import ru.shop.shoppingcart.dto.CustomerDTO;
import ru.shop.shoppingcart.service.CustomerService;
import ru.shop.shoppingcart.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(customerService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> readAll() {
        return ResponseEntity.ok(customerService.readAll());
    }

    @PutMapping
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.update(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
