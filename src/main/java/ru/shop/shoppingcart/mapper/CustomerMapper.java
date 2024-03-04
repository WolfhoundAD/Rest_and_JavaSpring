package ru.shop.shoppingcart.mapper;
import ru.shop.shoppingcart.dto.CustomerDTO;
import ru.shop.shoppingcart.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.mapstruct.factory.Mappers;
@Mapper
@Component
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerDTOToCustomer(CustomerDTO dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    CustomerDTO customerToCustomerDTO(Customer customer);

}
