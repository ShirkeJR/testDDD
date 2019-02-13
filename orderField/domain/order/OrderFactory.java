package com.printhouse.orderField.domain.order;

import com.printhouse.orderField.domain.Money;
import com.printhouse.orderField.domain.client.ClientData;
import com.printhouse.orderField.domain.policies.RebatePolicy;
import com.printhouse.orderField.domain.policies.RebatePolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {

    @Autowired
    private RebatePolicyFactory rebatePolicyFactory;

    public Order crateOrder(ClientData clientData) {

        Order order = new Order(clientData, Money.ZERO);

        RebatePolicy rebatePolicy = rebatePolicyFactory.createRebatePolicy(clientData.getClientStatus());
        order.setRebatePolicy(rebatePolicy);

        return order;
    }
}
