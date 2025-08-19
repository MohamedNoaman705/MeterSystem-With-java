package com.Azka.MeterSystemJava.domain.entity;

import com.Azka.MeterSystemJava.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Meter extends BaseEntity {
    private String serial;
    private String type;

    @OneToMany(mappedBy = "meter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recharge> recharges;

    @OneToOne(mappedBy = "meter", fetch = FetchType.LAZY)
    private Contract contract;
}
