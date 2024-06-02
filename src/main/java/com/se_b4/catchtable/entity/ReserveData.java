package com.se_b4.catchtable.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class ReserveData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reserveUID;

    private int reserverUUID;
    // private int diningId;
    private Date date;
    private LocalTime timeBegin;
    private int countPerson;
    private LocalDateTime reserveDate;
}
