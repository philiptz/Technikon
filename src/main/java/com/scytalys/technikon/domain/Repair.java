package com.scytalys.technikon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Repairs")
@SequenceGenerator(name = "idGenerator", sequenceName = "repair_seq", initialValue = 1, allocationSize = 1)
public class Repair extends BaseModel{
    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private RepairType repairType;
    @Enumerated(EnumType.STRING)
    @Column(length = 11, nullable = false)
    private RepairStatus repairStatus;
    @NotNull
    @Column(length = 100, nullable = false)
    private String description;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    private Date repairDate;
    @NotNull
    @Column(nullable = false)
    private BigDecimal cost;
}
