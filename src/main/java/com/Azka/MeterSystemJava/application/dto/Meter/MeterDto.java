package com.Azka.MeterSystemJava.application.dto.Meter;

import com.Azka.MeterSystemJava.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeterDto extends BaseEntity {
    private String serialNumber;
    private String type;
}
