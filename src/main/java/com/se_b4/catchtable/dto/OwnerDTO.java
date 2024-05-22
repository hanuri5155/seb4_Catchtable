package com.se_b4.catchtable.dto;

import com.se_b4.catchtable.entity.OwnerEntity;
import com.se_b4.catchtable.entity.UserEntity;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OwnerDTO extends UserDTO{
    private Long uuid; // 유저 고유 아이디

    private String businessDetails; // 사업장 정보
    private String restaurantManagementInfo; // 식당 관리 정보

    @Builder(builderMethodName = "ownerDTOBuilder")
    public static OwnerDTO toOwnerDTO(OwnerEntity entity, UserEntity userEntity) {
        return OwnerDTO.builder()
                .uuid(userEntity.getUuid())
                .businessDetails(entity.getBusinessDetails())
                .restaurantManagementInfo(entity.getRestaurantManagementInfo())
                .build();
    }
}
