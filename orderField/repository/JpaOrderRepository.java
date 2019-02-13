package com.printhouse.orderField.repository;

import com.printhouse.orderField.domain.order.Order;
import com.printhouse.orderField.domain.order.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderRepository extends GenericJpaRepository<Order> implements OrderRepository{


}
