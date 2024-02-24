package api.mapper;
import api.dto.CustomerDTO;
import api.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
@Mapper
@Component
public interface CustomerMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    CustomerDTO customerToCustomerDTO(Customer customer);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
