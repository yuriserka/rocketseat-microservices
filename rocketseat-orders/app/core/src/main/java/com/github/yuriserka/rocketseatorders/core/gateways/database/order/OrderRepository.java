package com.github.yuriserka.rocketseatorders.core.gateways.database.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.yuriserka.rocketseatorders.core.entities.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
