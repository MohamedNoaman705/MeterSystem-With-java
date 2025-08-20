package com.Azka.MeterSystemJava.application.service;

import com.Azka.MeterSystemJava.application.dto.BaseResponse;
import com.Azka.MeterSystemJava.application.dto.Contract.ContractDto;
import com.Azka.MeterSystemJava.application.dto.Contract.CreateContractDto;
import com.Azka.MeterSystemJava.domain.entity.Contract;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ContractService {
    BaseResponse<ContractDto> saveContract(CreateContractDto dto);
    BaseResponse<ContractDto> getOne(Specification<Contract> filter, boolean isTracking, String... props);
    BaseResponse<List<ContractDto>> getAll(Specification<Contract> filter, boolean isTracking, String... props);
    BaseResponse<Boolean> delete(Long id);
}
