package com.printhouse.orderField.domain.policies;

import com.printhouse.orderField.domain.Money;

import java.math.BigDecimal;

public class VipRebate implements RebatePolicy {

    private BigDecimal rebateRatio;

    private int mininalQuantity;

    public VipRebate(double rebate, int mininalQuantity) {
        rebateRatio = new BigDecimal(rebate*2 / 100);
        this.mininalQuantity = mininalQuantity;
    }

    @Override
    public Money calculateRebate(int quantity, Money regularCost){
        if (quantity >= mininalQuantity)
            return regularCost.multiplyBy(rebateRatio).subtract(new Money(20));
        return Money.ZERO;
    }
}
