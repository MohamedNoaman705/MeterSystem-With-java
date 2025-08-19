package com.Azka.MeterSystemJava.domain.entity;

import com.Azka.MeterSystemJava.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contract extends BaseEntity {
    private String customerCode;
    private String installationAddress;

    @Temporal(TemporalType.DATE)
    private Date activationDate;

    private double fixedFees;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_id")
    private Meter meter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
