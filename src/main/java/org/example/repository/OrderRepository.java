package org.example.repository;

import org.springframework.stereotype.Repository;
import org.example.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{
}
