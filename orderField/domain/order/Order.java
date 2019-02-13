package com.printhouse.orderField.domain.order;

import com.printhouse.orderField.domain.BaseEntity;
import com.printhouse.orderField.domain.Money;
import com.printhouse.orderField.domain.client.ClientData;
import com.printhouse.orderField.domain.policies.RebatePolicy;
import com.printhouse.orderField.domain.print.PrintData;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;

@Entity
public class Order extends BaseEntity {

    @Embedded
    private ClientData clientData;

    @Embedded
    private Money totalCost;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<OrderLine> items;

    @Transient
    private RebatePolicy rebatePolicy;

    private boolean submitted;

    public Order() {
    }

    Order(ClientData clientData, Money initialCost) {
        this.clientData = clientData;
        totalCost = initialCost;
        submitted = false;
        items = new HashSet<>();
    }

    public void addProduct(PrintData printData, int quantity, boolean isColored, byte[] printImage) {
        ifSubmitted();
        items.add(new OrderLine(printData, quantity, isColored, printImage, rebatePolicy));
    }

    public void setRebatePolicy(RebatePolicy rebatePolicy) {
        this.rebatePolicy = rebatePolicy;
    }

    public void calculate() {
        totalCost = Money.ZERO;
        for (OrderLine line : items) {
            line.recalculate(rebatePolicy);
            totalCost = totalCost.add(line.getEffectiveCost());
        }
    }

    public void submit() {
        submitted = true;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public Set<OrderLine> getItems() {
        return items;
    }

    public ClientData getClientData() {
        return clientData;
    }

    private void ifSubmitted() {
        if(submitted)
            throw new RuntimeException();
    }
}
