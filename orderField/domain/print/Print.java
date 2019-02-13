package com.printhouse.orderField.domain.print;

import com.printhouse.orderField.domain.BaseEntity;
import com.printhouse.orderField.domain.Money;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Print extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private PrintType type;

    private Money price;

    private String name;

    protected Print() {
    }

    public Print(PrintType type, Money price, String name, Boolean isColored, byte[] image) {
        this.type = type;
        this.price = price;
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;

    }

    public PrintType getType() {
        return type;
    }

    public PrintData generateSnapshot(){
        return new PrintData(entityId, type, price, name);
    }
}
