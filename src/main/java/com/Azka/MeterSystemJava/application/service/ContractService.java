package com.Azka.MeterSystemJava.application.service;

import com.Azka.MeterSystemJava.application.dto.BaseResponse;
import com.Azka.MeterSystemJava.application.dto.Contract.ContractDto;
import com.Azka.MeterSystemJava.application.dto.Contract.CreateContractDto;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ContractService {
    BaseResponse<ContractDto> saveContract(CreateContractDto contract);
    BaseResponse<ContractDto> getOne(Specification<ContractDto> filter, boolean isTracking, String... props);
    BaseResponse<List<ContractDto>> getAll(Specification<ContractDto> filter, boolean isTracking, String... props);
    BaseResponse<Boolean> delete(Long id);
}
