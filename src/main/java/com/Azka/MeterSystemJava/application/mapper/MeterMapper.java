package com.Azka.MeterSystemJava.application.mapper;

import com.Azka.MeterSystemJava.application.dto.Meter.CreateMeterDto;
import com.Azka.MeterSystemJava.application.dto.Meter.MeterDto;
import com.Azka.MeterSystemJava.domain.entity.Meter;

public class MeterMapper {
    public static MeterDto toDto(Meter meter){
        MeterDto dto = new MeterDto();
        dto.setId(meter.getId());
        dto.setType(meter.getType());
        dto.setSerialNumber(meter.getSerial());
        return dto;
    }

    public static Meter toEntity(CreateMeterDto dto){
        Meter meter = new Meter();
        meter.setSerial(dto.getSerialNumber());
        meter.setType(dto.getType());
        return meter;
    }
}
