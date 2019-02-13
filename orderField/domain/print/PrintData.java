package com.printhouse.orderField.domain.print;

import com.printhouse.orderField.domain.Money;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class PrintData {

    @Embedded
    private Long printId;

    @Enumerated(EnumType.STRING)
    private PrintType type;

    private Money price;

    private String name;

    public PrintData(Long printId, PrintType type, Money price, String name) {
        this.printId = printId;
        this.type = type;
        this.price = price;
        this.name = name;
    }

    public Long getPrintId() {
        return printId;
    }

    public PrintType getType() {
        return type;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
