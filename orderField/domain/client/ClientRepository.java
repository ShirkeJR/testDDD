package com.printhouse.orderField.domain.client;

public interface ClientRepository {
    public Client load(Long id);
    public void save(Client client);
}
