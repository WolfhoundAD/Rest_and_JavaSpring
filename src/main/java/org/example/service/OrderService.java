package org.example.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDTO;
import org.example.entity.Customer;
import org.example.entity.Orders;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository ordersRepository;
    private final CustomerService customerService;

    public Orders create(OrderDTO dto) {
        Customer customer = customerService.findById(dto.getCustomerId());
        Orders orders = new Orders();
        orders.setOrderDate(dto.getOrderDate());
        orders.setOrderStatus(dto.getOrderStatus());
        orders.setPaymentMethod(dto.getPaymentMethod());
        orders.setCustomer(customer);
        return ordersRepository.save(orders);
    }

    public List<Orders> readAll() {
        return ordersRepository.findAll();
    }

    public Orders update(Orders orders) {
        return ordersRepository.save(orders);
    }

    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }

    public Orders findById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }
}
