package com.Azka.MeterSystemJava.application.dto.Contract;

import com.Azka.MeterSystemJava.application.dto.Customer.CustomerDto;
import com.Azka.MeterSystemJava.application.dto.Meter.MeterDto;
import com.Azka.MeterSystemJava.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContractDto extends BaseEntity {
    private String customerCode;
    private String installationAddress;
    private double fixedFees;
    private Long MeterId;
    private Long CustomerId;
    private MeterDto meter;
    private CustomerDto customer;
}
