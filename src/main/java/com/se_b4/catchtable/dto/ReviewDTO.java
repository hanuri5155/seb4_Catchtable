package com.se_b4.catchtable.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int rating;
    private String description;
}
