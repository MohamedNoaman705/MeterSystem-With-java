package com.Azka.MeterSystemJava.application.dto.Customer;

import com.Azka.MeterSystemJava.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CustomerDto extends BaseEntity {
    private String nationalId;
    private String name;
    private String address;
}
