package com.se_b4.catchtable.dto;

import java.time.LocalDateTime;
import com.se_b4.catchtable.authority.UserAuthority;
import com.se_b4.catchtable.entity.MemberEntity;
import com.se_b4.catchtable.entity.UserEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true) //상위 클래스의 필드도 포함하도록 설정
@SuperBuilder
public class MemberDTO extends UserDTO{

    private String reviewContent;  // 리뷰 내용
    private String reportReason;   // 신고 사유

    public static MemberDTO toMemberDTO(MemberEntity entity) {
        return MemberDTO.builder()
                .uuid(entity.getUuid())
                .username(entity.getUsername())
                .userid(entity.getUserid())
                .password(entity.getPassword())
                .phone_number(entity.getPhone_number())
                .authority(entity.getAuthority())
                .join_date(entity.getJoin_date())
                .reviewContent(entity.getReviewContent())
                .reportReason(entity.getReportReason())
                .build();
    }
}
