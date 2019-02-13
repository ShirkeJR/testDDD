package com.printhouse.orderField.application.api;

public interface OrderingService {

    public void createOrder(Long clientId);
    public void addPrint(Long orderId, Long productId, int quantity, boolean isColored, byte[] printImage);
    public void approveOrder(Long orderId);
}