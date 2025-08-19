package com.Azka.MeterSystemJava.application.dto.Contract;

import com.Azka.MeterSystemJava.application.dto.Customer.CreateCustomerDto;
import com.Azka.MeterSystemJava.application.dto.Meter.CreateMeterDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateContractDto {
    private String installationAddress;
    private double fixedFees;
    private CreateMeterDto meterDto;
    private CreateCustomerDto customerDto;
}
