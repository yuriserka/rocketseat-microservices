package com.github.yuriserka.rocketseatorders.core.gateways.database.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.yuriserka.rocketseatorders.core.entities.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomerId(Long customerId);
}
