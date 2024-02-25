package api.service;

import api.mapper.CustomerMapper;
import api.repository.CustomerRepository;
import api.dto.CustomerDTO;
import api.entity.Customer;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.mapstruct.factory.Mappers;

import java.util.List;

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
        return customerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cannot find customer by id" + id));
    }
}
