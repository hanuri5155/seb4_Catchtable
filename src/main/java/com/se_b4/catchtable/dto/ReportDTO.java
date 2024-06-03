package com.se_b4.catchtable.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReportDTO
{
    private static final long serialVersionUID = 1L;

    private boolean illegal_service;
    private boolean poor_hygiene;
    private boolean unkind;
    private boolean etc;
    private String reason;
}
