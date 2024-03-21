package ru.shop.shoppingcart.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.shop.shoppingcart.enumClass.OrderStatus;
import ru.shop.shoppingcart.enumClass.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private Long customerId;
}
