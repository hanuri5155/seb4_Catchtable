package com.se_b4.catchtable.dto;

import com.se_b4.catchtable.entity.MemberEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true) //상위 클래스의 필드도 포함하도록 설정
@SuperBuilder
public class MemberDTO extends UserDTO{

    public static MemberDTO toMemberDTO(MemberEntity entity) {
        return MemberDTO.builder()
                .uuid(entity.getUuid())
                .username(entity.getUsername())
                .userid(entity.getUserid())
                .password(entity.getPassword())
                .phone_number(entity.getPhone_number())
                .authority(entity.getAuthority())
                .join_date(entity.getJoin_date())
                .build();
    }
}
