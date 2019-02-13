package com.printhouse.orderField.domain.client;

import com.printhouse.orderField.domain.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Client extends BaseEntity {

    private String name;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private ClientStatus clientStatus;

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    public ClientData generateSnapshot(){
        return new ClientData(entityId, name, clientStatus);
    }
}
