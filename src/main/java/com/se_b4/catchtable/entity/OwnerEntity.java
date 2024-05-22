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
public class OwnerEntity extends UserEntity{

    private String businessDetails; // 사업장 정보
    private String restaurantManagementInfo; // 식당 관리 정보

    @Builder
    public OwnerEntity(Long uuid, String userid, String username, String password, String phone_number, LocalDateTime join_date, UserAuthority authority) {
        super(uuid, userid, username, password, phone_number, join_date, authority);
        this.businessDetails = businessDetails;
        this.restaurantManagementInfo = restaurantManagementInfo;
    }
}
