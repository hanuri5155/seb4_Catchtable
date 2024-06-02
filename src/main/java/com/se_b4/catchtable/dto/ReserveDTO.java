package com.se_b4.catchtable.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReserveDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private DiningDTO dining_dto;

    private int reserver_uuid;
    private int count_person;
    private LocalDate reserve_date;
    private LocalTime reserve_time;
}
