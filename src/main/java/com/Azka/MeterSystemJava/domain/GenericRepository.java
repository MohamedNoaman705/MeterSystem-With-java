package com.Azka.MeterSystemJava.domain;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface GenericRepository <T, ID>{
    T save(T entity);
    Optional<T> getOne(Specification<T> spec, boolean isTracking, String... props);
    List<T> getAll(Specification<T> spec, boolean isTracking, String... props);
    void delete(T entity);
    T update(T entity);
}
