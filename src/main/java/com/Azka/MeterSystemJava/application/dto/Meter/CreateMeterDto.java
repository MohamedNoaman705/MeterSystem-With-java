package com.Azka.MeterSystemJava.application.dto.Meter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateMeterDto {
    private String serialNumber;
    private String type;
}
