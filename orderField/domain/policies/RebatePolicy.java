package com.printhouse.orderField.domain.policies;

import com.printhouse.orderField.domain.Money;

public interface RebatePolicy {
    public Money calculateRebate(int quantity, Money regularCost);
}
