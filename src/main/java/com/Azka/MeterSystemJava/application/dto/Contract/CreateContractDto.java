package com.Azka.MeterSystemJava.application.dto.Contract;

import com.Azka.MeterSystemJava.application.dto.Customer.CreateCustomerDto;
import com.Azka.MeterSystemJava.application.dto.Meter.CreateMeterDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateContractDto {
    private String installationAddress;
    private double fixedFees;
    @JsonProperty("meterDTO")
    private CreateMeterDto meterDto;
    @JsonProperty("customerDTO")
    private CreateCustomerDto customerDto;
}
