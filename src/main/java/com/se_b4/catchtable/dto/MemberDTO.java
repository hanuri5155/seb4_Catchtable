package com.se_b4.catchtable.dto;

import com.se_b4.catchtable.entity.MemberEntity;
import com.se_b4.catchtable.entity.UserEntity;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO extends UserDTO{
    private Long uuid; // 유저 고유 아이디

    private String reviewContent;  // 리뷰 내용
    private String reportReason;   // 신고 사유

    @Builder(builderMethodName = "memberDTOBuilder")
    public static MemberDTO toMemberDTO(MemberEntity entity, UserEntity userEntity) {
        return MemberDTO.builder()
                .uuid(userEntity.getUuid())
                .reviewContent(entity.getReviewContent())
                .reportReason(entity.getReportReason())
                .build();
    }
}
