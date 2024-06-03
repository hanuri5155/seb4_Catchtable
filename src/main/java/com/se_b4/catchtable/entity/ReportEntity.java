package com.se_b4.catchtable.entity;

import jakarta.persistence.*;
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

    private int dining_uid;
    private boolean illegal_service;
    private boolean poor_hygiene;
    private boolean unkind;
    private boolean etc;
    private String reason;
}
