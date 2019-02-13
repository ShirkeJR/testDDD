package com.printhouse.orderField.domain.order;

import com.printhouse.orderField.domain.BaseEntity;
import com.printhouse.orderField.domain.Money;
import com.printhouse.orderField.domain.policies.RebatePolicy;
import com.printhouse.orderField.domain.print.PrintData;

import javax.persistence.*;

@Entity
public class OrderLine extends BaseEntity{

    @Embedded
    private PrintData printData;

    private int quantity;

    private Boolean colored;

    private byte[] printImage;

    @Embedded
    private Money regularCost;

    @Embedded
    private Money effectiveCost;

    public OrderLine(){

    }

    OrderLine(PrintData printData, int quantity, boolean colored, byte[] printImage, RebatePolicy rebatePolicy) {
        this.printData = printData;
        this.quantity = quantity;
        this.colored = colored;
        this.printImage = printImage;
        recalculate(rebatePolicy);
    }

    public void recalculate(RebatePolicy rebatePolicy) {
        regularCost = printData.getPrice().multiplyBy(quantity);
        Money rebate = rebatePolicy.calculateRebate(quantity, regularCost);
        effectiveCost = regularCost.subtract(rebate);
    }

    public PrintData getPrint() {
        return printData;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getRegularCost() {
        return regularCost;
    }

    public Money getEffectiveCost() {
        return effectiveCost;
    }

    public PrintData getPrintData() {
        return printData;
    }

    public Boolean getColored() {
        return colored;
    }

    public byte[] getPrintImage() {
        return printImage;
    }
}
