package ru.shop.shoppingcart.controller.v1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.shop.shoppingcart.dto.CustomerDTO;
import ru.shop.shoppingcart.service.CustomerService;
import ru.shop.shoppingcart.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(customerService.create(dto));
    }

    @GetMapping("/")
    public ResponseEntity<Page<CustomerDTO>> readAll(Pageable pageable) {
        Page<CustomerDTO> customerDTOPage = customerService.readAll(pageable);
        return ResponseEntity.ok(customerDTOPage);
    }

    @PutMapping("/")
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO dto) {
        CustomerDTO updatedCustomerDTO = customerService.update(dto);
        return ResponseEntity.ok(updatedCustomerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
