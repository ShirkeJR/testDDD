package com.printhouse.orderField.domain;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long entityId;

    @Version
    private Long version;

    public Long getEntityId() {
        return entityId;
    }
}
