package com.printhouse.orderField.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;


@Embeddable
public class Money implements Serializable {

    public static final Money ZERO = new Money(BigDecimal.ZERO);

    private BigDecimal value;

    private String currencyCode;

    protected Money() {
    }

    private Money(BigDecimal value) {
        this.value = value.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Money(double value) {
        this(new BigDecimal(value));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            Money money = (Money) obj;
            return compatibleCurrency(money) && value.equals(money.value);
        }
        return false;
    }

    public Money multiplyBy(double multiplier) {
        return multiplyBy(new BigDecimal(multiplier));
    }

    public Money multiplyBy(BigDecimal multiplier) {
        return new Money(value.multiply(multiplier));
    }

    public Money add(Money money) {
        if (!compatibleCurrency(money)) {
            throw new IllegalArgumentException("Currency mismatch");
        }

        return new Money(value.add(money.value));
    }

    public Money subtract(Money money) {
        if (!compatibleCurrency(money))
            throw new IllegalArgumentException("Currency mismatch");

        return new Money(value.subtract(money.value));
    }

    private boolean compatibleCurrency(Money money) {
        return isZero(value) || isZero(money.value);
    }

    private boolean isZero(BigDecimal testedValue) {
        return BigDecimal.ZERO.compareTo(testedValue) == 0;
    }

    public boolean greaterThan(Money other) {
        return value.compareTo(other.value) > 0;
    }

    public boolean lessThan(Money other) {
        return value.compareTo(other.value) < 0;
    }

    public boolean lessOrEquals(Money other) {
        return value.compareTo(other.value) <= 0;
    }
}
