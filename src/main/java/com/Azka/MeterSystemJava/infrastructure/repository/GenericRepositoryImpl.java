package com.Azka.MeterSystemJava.infrastructure.repository;

import com.Azka.MeterSystemJava.domain.GenericRepository;
import com.Azka.MeterSystemJava.domain.entity.Contract;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
public class GenericRepositoryImpl<T> implements GenericRepository<T, Long> {

    private final EntityManager em;
    private final Class<T> entityClass;

    public GenericRepositoryImpl(EntityManager em, Class<T> entityClass){
        this.em = em;
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity) {
        return em.merge(entity);
    }

    @Override
    public Optional<T> getOne(Specification<T> spec, boolean isTracking, String... props) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);

        if (spec != null){
            cq.where(spec.toPredicate(root, cq, cb));
        }

        if (props != null){
            for (String prop : props){
                root.fetch(prop.trim(), JoinType.LEFT);
            }
        }

        TypedQuery<T> query = em.createQuery(cq);
        query.setHint("org.hibernate.readOnly", !isTracking);

        return query.getResultStream().findFirst();
    }

    @Override
    public List<T> getAll(Specification<T> spec, boolean isTracking, String... props) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);

        if (spec != null) {
            cq.where(spec.toPredicate(root, cq, cb));
        }

        if (props != null) {
            for (String prop : props) {
                root.fetch(prop.trim(), JoinType.LEFT);
            }
        }

        TypedQuery<T> query = em.createQuery(cq);
        query.setHint("org.hibernate.readOnly", !isTracking);

        return query.getResultList();
    }

    @Override
    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    public String getLastCustomerCode() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<Contract> root = cq.from(Contract.class);

        cq.select(root.get("customerCode"));
        cq.orderBy(cb.desc(root.get("id")));

        TypedQuery<String> query = em.createQuery(cq);
        query.setMaxResults(1);

        String lastCode = query.getResultStream().findFirst().orElse("0000");
        return lastCode;
    }

}
