package com.printhouse.orderField.domain.client;

import javax.persistence.*;

@Embeddable
public class ClientData {

    @Embedded
    private Long clientId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ClientStatus clientStatus;

    private ClientData(){}

    public ClientData(Long clientId, String name, ClientStatus clientStatus) {
        this.clientId = clientId;
        this.name = name;
        this.clientStatus = clientStatus;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public ClientStatus getClientStatus() {
        return clientStatus;
    }
}
