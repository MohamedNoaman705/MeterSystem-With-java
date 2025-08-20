package com.Azka.MeterSystemJava.application.mapper;

import com.Azka.MeterSystemJava.application.dto.Contract.ContractDto;
import com.Azka.MeterSystemJava.application.dto.Contract.CreateContractDto;
import com.Azka.MeterSystemJava.domain.entity.Contract;

public class ContractMapper {
    public static ContractDto toDto(Contract contract){
        ContractDto dto = new ContractDto();
        dto.setId(contract.getId());
        dto.setCustomerCode(contract.getCustomer() != null ? contract.getCustomer().getName() : null);
        dto.setInstallationAddress(contract.getInstallationAddress());
        dto.setFixedFees(contract.getFixedFees());
        dto.setMeterId(contract.getMeter() != null ? contract.getMeter().getId() : null);
        dto.setCustomerId(contract.getCustomer() != null ? contract.getCustomer().getId() : null);
        dto.setCreatedAt(contract.getCreatedAt());
        dto.setUpdatedAt(contract.getUpdatedAt());
        return dto;
    }

    public static Contract toEntity(CreateContractDto dto){
        Contract contract = new Contract();
        contract.setInstallationAddress(dto.getInstallationAddress());
        contract.setFixedFees(dto.getFixedFees());
        return contract;
    }

}
