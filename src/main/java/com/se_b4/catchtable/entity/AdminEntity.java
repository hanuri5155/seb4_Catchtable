package com.se_b4.catchtable.entity;

import com.se_b4.catchtable.authority.UserAuthority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity extends UserEntity{

    private String businessReviewDetails; // 사업장 검토 정보

    @Builder
    public AdminEntity(Long uuid, String userid, String username, String password, String phone_number, LocalDateTime join_date, UserAuthority authority) {
        super(uuid, userid, username, password, phone_number, join_date, authority);
        this.businessReviewDetails = businessReviewDetails;
    }
}
