package com.se_b4.catchtable.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "report_entity")
public class ReportEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @NotNull
    private int dining_uid;

    @NotNull
    private Long reporter_uuid;

    private boolean illegal_service;
    private boolean poor_hygiene;
    private boolean unkind;
    private boolean etc;
    private String reason;
}
