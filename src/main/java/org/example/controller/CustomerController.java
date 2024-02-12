package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody CustomerDTO dto) {
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
    public HttpStatus delete(@PathVariable Long id) {
        customerService.delete(id);
        return HttpStatus.OK;
    }
}
