package org.example.dto;
import lombok.Data;
import org.example.enumClass.OrderStatus;
import org.example.enumClass.PaymentMethod;

import java.time.LocalDate;
@Data
public class OrderDTO {
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private Long customerId;
}
