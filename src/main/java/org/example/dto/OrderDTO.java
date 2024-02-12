package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.enumClass.OrderStatus;
import org.example.enumClass.PaymentMethod;

import java.time.LocalDate;

@Getter
@Setter
public class OrderDTO {
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private Long customerId;
}
