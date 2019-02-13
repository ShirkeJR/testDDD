package com.printhouse.orderField.domain.policies;

import com.printhouse.orderField.domain.Money;

import java.math.BigDecimal;

public class StandardRebate implements RebatePolicy {

    private BigDecimal rebateRatio;

    private int mininalQuantity;

    public StandardRebate(double rebate, int mininalQuantity) {
        rebateRatio = new BigDecimal(rebate / 100);
        this.mininalQuantity = mininalQuantity;
    }

    @Override
    public Money calculateRebate(int quantity, Money regularCost){
        if (quantity >= mininalQuantity)
            return regularCost.multiplyBy(rebateRatio);
        return Money.ZERO;
    }
}
