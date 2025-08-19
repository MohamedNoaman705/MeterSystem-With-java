package com.Azka.MeterSystemJava.application.service;

import com.Azka.MeterSystemJava.application.dto.BaseResponse;
import com.Azka.MeterSystemJava.application.dto.Contract.ContractDto;
import com.Azka.MeterSystemJava.application.dto.Contract.CreateContractDto;
import com.Azka.MeterSystemJava.domain.GenericRepository;
import com.Azka.MeterSystemJava.domain.entity.Contract;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ContractServiceImpl implements ContractService{

    private final GenericRepository<Contract, Long> contractRepository;

    public ContractServiceImpl(GenericRepository<Contract, Long> contractRepository){
        this.contractRepository = contractRepository;
    }

    @Override
    public BaseResponse<ContractDto> saveContract(CreateContractDto contract) {
        return null;
    }

    @Override
    public BaseResponse<ContractDto> getOne(Specification<ContractDto> filter, boolean isTracking, String... props) {
        return null;
    }

    @Override
    public BaseResponse<List<ContractDto>> getAll(Specification<ContractDto> filter, boolean isTracking, String... props) {
        return null;
    }

    @Override
    public BaseResponse<Boolean> delete(Long id) {
        return null;
    }
}
