package com.Azka.MeterSystemJava.domain.entity;

import com.Azka.MeterSystemJava.domain.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Recharge extends BaseEntity {
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_id")
    private Meter meter;
}
