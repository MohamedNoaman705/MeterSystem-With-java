package com.Azka.MeterSystemJava.application.mapper;

import com.Azka.MeterSystemJava.application.dto.Customer.CreateCustomerDto;
import com.Azka.MeterSystemJava.application.dto.Customer.CustomerDto;
import com.Azka.MeterSystemJava.domain.entity.Customer;

public class CustomerMapper {
    public static CustomerDto toDto(Customer customer){
        CustomerDto dto = new CustomerDto();
        dto.setNationalId(customer.getNationalId());
        dto.setName(customer.getName());
        dto.setName(customer.getAddress());
        return dto;
    }

    public static Customer toEntity(CreateCustomerDto dto){
        Customer customer = new Customer();
        customer.setNationalId(dto.getNationalId());
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        return customer;
    }
}
