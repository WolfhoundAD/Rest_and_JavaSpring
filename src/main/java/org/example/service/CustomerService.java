package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer create(CustomerDTO dto) {
        return customerRepository.save(Customer.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build());
    }
    public List<Customer> readAll() {
        return  customerRepository.findAll();
    }
    public  Customer update(Customer customer){
        return  customerRepository.save(customer);
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }
}
