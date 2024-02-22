package api.service;

import api.mapper.CustomerMapper;
import api.repository.CustomerRepository;
import api.dto.CustomerDTO;
import api.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    public CustomerDTO create(CustomerDTO dto) {
        Customer customer = customerMapper.customerDTOToCustomer(dto);
        return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
    }

    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }
}
