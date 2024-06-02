package com.se_b4.catchtable.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dining_entity")
public class DiningData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    private Long owner_uuid;

    private String name;
    private String address;
    private String tel;
    private String description;
    private int min_count_person;
    private int max_count_person;
    private int count_seat;
    private int count_reported;

    @Override
    public String toString()
    {
        String[] stringBuilder = new String[10];
        stringBuilder[0] = "식당 정보:";
        stringBuilder[1] = String.format("\n  - uid: %s", uid);
        stringBuilder[2] = String.format("\n  - name: %s", name);
        stringBuilder[3] = String.format("\n  - address: %s", address);
        stringBuilder[4] = String.format("\n  - tel: %s", tel);
        stringBuilder[5] = String.format("\n  - description: %s", description);

        return stringBuilder[0]
                + stringBuilder[1]
                + stringBuilder[2]
                + stringBuilder[3]
                + stringBuilder[4]
                + stringBuilder[5];
    }
}