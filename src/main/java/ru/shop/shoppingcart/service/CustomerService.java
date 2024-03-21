package ru.shop.shoppingcart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.shop.shoppingcart.mapper.CustomerMapper;
import ru.shop.shoppingcart.repository.CustomerRepository;
import ru.shop.shoppingcart.dto.CustomerDTO;
import ru.shop.shoppingcart.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    /**
     * Создает нового клиента на основе переданных данных.
     *
     * @param dto данные клиента для создания
     * @return созданный объект Customer
     */

    public CustomerDTO create(CustomerDTO dto) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(dto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.customerToCustomerDTO(savedCustomer);
    }

    public Page<CustomerDTO> readAll(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers.map(CustomerMapper.INSTANCE::customerToCustomerDTO);
    }
    public CustomerDTO update(CustomerDTO dto) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(dto);
        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.customerToCustomerDTO(updatedCustomer);
    }

    public void delete(Long id) {
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete customer with id: " + id, e);
        }
    }

    public Customer findById(Long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            return customer.orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Failed to find customer with id: " + id, e);
        }
    }
}
