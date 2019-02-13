package com.printhouse.orderField.application.impl;

import com.printhouse.orderField.application.api.OrderingService;
import com.printhouse.orderField.domain.print.Print;
import com.printhouse.orderField.domain.client.Client;
import com.printhouse.orderField.domain.order.Order;
import com.printhouse.orderField.domain.order.OrderFactory;
import com.printhouse.orderField.repository.JpaClientRepository;
import com.printhouse.orderField.repository.JpaOrderRepository;
import com.printhouse.orderField.repository.JpaPrintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderingServiceImpl implements OrderingService{

    @Autowired
    private JpaOrderRepository jpaOrderRepository;

    @Autowired
    private OrderFactory orderFactory;

    @Autowired
    private JpaClientRepository jpaClientRepository;

    @Autowired
    private JpaPrintRepository jpaPrintRepository;

    @Override
    public void createOrder(Long clientId) {
        Client client = jpaClientRepository.load(clientId);
        Order order = orderFactory.crateOrder(client.generateSnapshot());
        jpaOrderRepository.save(order);
    }

    @Override
    public void addPrint(Long orderId, Long productId, int quantity, boolean isColored, byte[] printImage) {
        Order order = jpaOrderRepository.load(orderId);
        Print product = jpaPrintRepository.load(productId);
        order.addProduct(product.generateSnapshot(), quantity, isColored, printImage);
        jpaOrderRepository.save(order);
    }

    @Override
    public void approveOrder(Long orderId) {
        Order order = jpaOrderRepository.load(orderId);
        order.calculate();
        order.submit();
        jpaOrderRepository.save(order);
    }
}

