package com.Azka.MeterSystemJava.infrastructure.repository.config;

import com.Azka.MeterSystemJava.domain.entity.Contract;
import com.Azka.MeterSystemJava.domain.entity.Customer;
import com.Azka.MeterSystemJava.domain.entity.Meter;
import com.Azka.MeterSystemJava.infrastructure.repository.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @PersistenceContext
    private EntityManager em;

    @Bean
    public GenericRepositoryImpl<Contract> contractRepository() {
        return new GenericRepositoryImpl<>(em, Contract.class);
    }

    @Bean
    public GenericRepositoryImpl<Customer> customerRepository() {
        return new GenericRepositoryImpl<>(em, Customer.class);
    }

    @Bean
    public GenericRepositoryImpl<Meter> meterRepository() {
        return new GenericRepositoryImpl<>(em, Meter.class);
    }
}
