package com.se_b4.catchtable.dto;

import com.se_b4.catchtable.entity.AdminEntity;
import com.se_b4.catchtable.entity.UserEntity;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminDTO extends UserDTO{
    private Long uuid; // 유저 고유 아이디

    private String businessReviewDetails; // 사업장 검토 정보

    @Builder(builderMethodName = "adminDTOBuilder")
    public static AdminDTO toAdminDTO(AdminEntity entity, UserEntity userEntity) {
        return AdminDTO.builder()
                .uuid(userEntity.getUuid())
                .businessReviewDetails(entity.getBusinessReviewDetails())
                .build();
    }
}
