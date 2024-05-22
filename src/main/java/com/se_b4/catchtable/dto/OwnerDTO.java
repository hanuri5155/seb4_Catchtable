package com.se_b4.catchtable.dto;

import java.time.LocalDateTime;
import com.se_b4.catchtable.authority.UserAuthority;
import com.se_b4.catchtable.entity.OwnerEntity;
import com.se_b4.catchtable.entity.UserEntity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class OwnerDTO extends UserDTO{

    private String businessDetails; // 사업장 정보
    private String restaurantManagementInfo; // 식당 관리 정보


    public static OwnerDTO toOwnerDTO(OwnerEntity entity) {
        return OwnerDTO.builder()
                .uuid(entity.getUuid())
                .username(entity.getUsername())
                .userid(entity.getUserid())
                .password(entity.getPassword())
                .phone_number(entity.getPhone_number())
                .authority(entity.getAuthority())
                .join_date(entity.getJoin_date())
                .businessDetails(entity.getBusinessDetails())
                .restaurantManagementInfo(entity.getRestaurantManagementInfo())
                .build();
    }
}
