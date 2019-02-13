package com.printhouse.orderField.domain.policies;

import com.printhouse.orderField.domain.client.ClientStatus;
import org.springframework.stereotype.Component;

@Component
public class RebatePolicyFactory {

    public RebatePolicy createRebatePolicy(ClientStatus clientStatus) {
        RebatePolicy rebatePolicy = new StandardRebate(10, 50);

        if (isVip(clientStatus)){
            rebatePolicy = new VipRebate(10, 10);
        }

        return rebatePolicy;
    }

    private boolean isVip(ClientStatus clientStatus) {
        return clientStatus.equals(ClientStatus.VIP);
    }
}
