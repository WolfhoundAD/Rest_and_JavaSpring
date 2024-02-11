package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

        private  final CustomerService customerService;

        @PostMapping
        public ResponseEntity<Customer> create(@RequestBody CustomerDTO dto){
            return new ResponseEntity<>(customerService.create(dto), HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<List<Customer>> readAll(){
            return  new ResponseEntity<>(customerService.readAll(), HttpStatus.OK);
        }

        @PutMapping
        public ResponseEntity<Customer> update(@RequestBody Customer customer){
            return  new ResponseEntity<>(customerService.update(customer), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public HttpStatus delete(@PathVariable Long id) {
            customerService.delete(id);
            return HttpStatus.OK;
        }
}
