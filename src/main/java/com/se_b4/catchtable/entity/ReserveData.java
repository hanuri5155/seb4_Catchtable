package com.se_b4.catchtable.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserve_entity")
public class ReserveData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    private Long reserver_uuid;
    private int dining_uid;
    private Date date;
    private LocalTime time_begin;
    private int count_person;
    private LocalDateTime reserve_date;

    @Override
    public String toString()
    {
        String[] stringBuilder = new String[10];
        stringBuilder[0] = "예약 정보:";
        stringBuilder[1] = String.format("\n  - uid: %s", uid);
        stringBuilder[2] = String.format("\n  - reserver_uuid: %s", reserver_uuid);
        stringBuilder[3] = String.format("\n  - dining_id: %s", dining_uid);
        stringBuilder[4] = String.format("\n  - time_begin: %s", time_begin);
        stringBuilder[5] = String.format("\n  - reserve_date: %s", reserve_date);

        return stringBuilder[0]
                + stringBuilder[1]
                + stringBuilder[2]
                + stringBuilder[3]
                + stringBuilder[4]
                + stringBuilder[5];
    }
}
