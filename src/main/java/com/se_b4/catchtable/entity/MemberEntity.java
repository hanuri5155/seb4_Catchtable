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
public class MemberEntity extends UserEntity{

    private String reviewContent; // 리뷰 내용
    private String reportReason;  // 신고 사유

    @Builder
    public MemberEntity(Long uuid, String userid, String username, String password, String phone_number, LocalDateTime join_date, UserAuthority authority) {
        super(uuid, userid, username, password, phone_number, join_date, authority);
        this.reviewContent = reviewContent;
        this.reportReason = reportReason;
    }
}
