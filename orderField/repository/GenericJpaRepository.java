package com.printhouse.orderField.repository;

import com.printhouse.orderField.domain.BaseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

public abstract class GenericJpaRepository<A extends BaseEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<A> clazz;

    @SuppressWarnings("unchecked")
    public GenericJpaRepository() {
        this.clazz = ((Class<A>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public A load(Long id) {
        A aggregate = entityManager.find(clazz, id, LockModeType.OPTIMISTIC);

        if (aggregate == null)
            throw new RuntimeException("Object does not exist");

        return aggregate;
    }

    public void save(A aggregate) {
        if (entityManager.contains(aggregate)){
            entityManager.lock(aggregate, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        }
        else{
            entityManager.persist(aggregate);
        }
    }
}
