package com.printhouse.orderField.domain.order;

public interface OrderRepository {
    public Order load(Long id);
    public void save(Order client);
}
