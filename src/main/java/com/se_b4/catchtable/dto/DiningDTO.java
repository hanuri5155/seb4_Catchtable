package com.se_b4.catchtable.dto;

import com.se_b4.catchtable.entity.DiningData;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiningDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String name;
    private String address;
    private String tel;
    private String description;
    private int min_count_person;
    private int max_count_person;
    private int count_seat;

    public static DiningDTO toDTO(DiningData entity)
    {
        return DiningDTO.builder()
                .name(entity.getName())
                .address(entity.getAddress())
                .tel(entity.getTel())
                .description(entity.getDescription())
                .min_count_person(entity.getMin_count_person())
                .max_count_person(entity.getMax_count_person())
                .count_seat(entity.getCount_seat())
                .build();
    }
}
