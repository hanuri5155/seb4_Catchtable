package com.se_b4.catchtable.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "review_entity")
public class ReviewEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private int dining_uid;
    private int reviewer_uuid;
    private int rating;
    private String description;
}
