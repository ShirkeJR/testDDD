package com.printhouse.orderField.repository;

import com.printhouse.orderField.domain.client.Client;
import com.printhouse.orderField.domain.client.ClientRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaClientRepository extends GenericJpaRepository<Client> implements ClientRepository{
}
