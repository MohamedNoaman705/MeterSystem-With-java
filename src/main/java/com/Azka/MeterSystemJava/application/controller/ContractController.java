package com.Azka.MeterSystemJava.application.controller;

import com.Azka.MeterSystemJava.application.dto.BaseResponse;
import com.Azka.MeterSystemJava.application.dto.Contract.ContractDto;
import com.Azka.MeterSystemJava.application.dto.Contract.CreateContractDto;
import com.Azka.MeterSystemJava.application.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
        private final ContractService contractService;
        public ContractController(ContractService contractService){
            this.contractService = contractService;
        }

    @PostMapping
    public ResponseEntity<BaseResponse<ContractDto>> createContract(@RequestBody CreateContractDto dto) {
        BaseResponse<ContractDto> response = contractService.saveContract(dto);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
