package com.Azka.MeterSystemJava.application.dto.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CustomerDto {
    private String nationalId;
    private String name;
    private String address;
}
