package api.mapper;
import api.dto.CustomerDTO;
import api.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
@Mapper
@Component
public interface CustomerMapper {
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
