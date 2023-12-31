package com.scytalys.technikon.dto;

import com.scytalys.technikon.domain.ReportType;
import com.scytalys.technikon.domain.User;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReportDto {
    private Long id;
    private Date reportDate;
    private ReportType reportType;
    private String reportDescription;
    private User user;
}