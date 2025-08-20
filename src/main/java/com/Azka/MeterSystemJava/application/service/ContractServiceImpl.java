package com.Azka.MeterSystemJava.application.service;

import com.Azka.MeterSystemJava.application.dto.BaseResponse;
import com.Azka.MeterSystemJava.application.dto.Contract.ContractDto;
import com.Azka.MeterSystemJava.application.dto.Contract.CreateContractDto;
import com.Azka.MeterSystemJava.application.mapper.ContractMapper;
import com.Azka.MeterSystemJava.application.mapper.CustomerMapper;
import com.Azka.MeterSystemJava.application.mapper.MeterMapper;
import com.Azka.MeterSystemJava.application.util.Messages;
import com.Azka.MeterSystemJava.domain.GenericRepository;
import com.Azka.MeterSystemJava.domain.entity.Contract;
import com.Azka.MeterSystemJava.domain.entity.Customer;
import com.Azka.MeterSystemJava.domain.entity.Meter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService{

    private final GenericRepository<Contract, Long> contractRepository;
    private final GenericRepository<Meter, Long> meterRepository;
    private final GenericRepository<Customer, Long> customerRepository;

    public ContractServiceImpl(GenericRepository<Contract, Long> contractRepository,
                               GenericRepository<Meter, Long> meterRepository,
                               GenericRepository<Customer, Long> customerRepository){
        this.contractRepository = contractRepository;
        this.meterRepository = meterRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public BaseResponse<ContractDto> saveContract(CreateContractDto dto) {
        try {
            Contract contract = ContractMapper.toEntity(dto);
            Meter meter = MeterMapper.toEntity(dto.getMeterDto());
            Customer customer = CustomerMapper.toEntity(dto.getCustomerDto());

            Optional<Meter> existingMeter = meterRepository.getOne(
                    (root, query, cb) -> cb.equal(root.get("serial"), meter.getSerial()), true
            );
            if (existingMeter.isPresent())
                return BaseResponse.error(Messages.ALREADY_EXIST);

            Meter savedMeter = meterRepository.save(meter);

            Optional<Customer> existingCustomer = customerRepository.getOne(
                    (root, query, cb) -> cb.equal(root.get("nationalId"),
                            customer.getNationalId()), true
            );
            String lastCode = contractRepository.getLastCustomerCode(); // implement
            int nextCode = 1;
            try { nextCode = Integer.parseInt(lastCode) + 1; } catch (NumberFormatException ignored) {}
            contract.setCustomerCode(String.format("%04d", nextCode));

            if (existingCustomer.isPresent()) contract.setCustomer(existingCustomer.get());
            else contract.setCustomer(customerRepository.save(customer));

            contract.setMeter(savedMeter);
            Contract savedContract = contractRepository.save(contract);

            return BaseResponse.success(ContractMapper.toDto(savedContract), Messages.CREATED);
        } catch (Exception e) {
            return BaseResponse.error(e.getMessage());
        }
    }

    @Override
    public BaseResponse<ContractDto> getOne(Specification<Contract> filter, boolean isTracking, String... props) {
        try {
            Optional<Contract> entity = contractRepository.getOne(filter, isTracking, props);
            if (entity.isPresent()) {
                return BaseResponse.success(ContractMapper.toDto(entity.get()), Messages.LOADED);
            } else {
                return BaseResponse.error(Messages.NOT_FOUND);
            }
        } catch (Exception e) {
            return BaseResponse.error(e.getMessage());
        }
    }

    @Override
    public BaseResponse<List<ContractDto>> getAll(Specification<Contract> filter, boolean isTracking, String... props) {
        try {
            List<Contract> entities = contractRepository.getAll(filter, isTracking, props);
            if (entities.isEmpty()) {
                return BaseResponse.error(Messages.NOT_FOUND);
            }
            List<ContractDto> dtos = entities.stream()
                    .map(ContractMapper::toDto)
                    .toList();
            return BaseResponse.success(dtos, Messages.LOADED);
        } catch (Exception e) {
            return BaseResponse.error(e.getMessage());
        }
    }

    @Override
    public BaseResponse<Boolean> delete(Long id) {
        try {
            Optional<Contract> entity = contractRepository.getOne(
                    (root, query, cb) -> cb.equal(root.get("id"), id),
                    true,
                    "meter", "customer"
            );

            if (entity.isEmpty()) return BaseResponse.error(Messages.NOT_FOUND);

            Contract contract = entity.get();

            // Optional: delete associated entities if needed
            Meter meter = contract.getMeter();
            Customer customer = contract.getCustomer();

            contractRepository.delete(contract);
            if (meter != null) meterRepository.delete(meter);
            // customerRepository.delete(customer); // only if you want to delete customer

            return BaseResponse.success(true, Messages.DELETED);
        } catch (Exception e) {
            return BaseResponse.error(e.getMessage());
        }
    }
}
