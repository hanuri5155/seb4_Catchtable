package com.se_b4.catchtable.dto;

import com.se_b4.catchtable.authority.UserAuthority;
import com.se_b4.catchtable.entity.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder
public class UserDTO {
    // Spring 에서 DTO 를 초기화 할 때 멤버 변수를 Null 로 초기화 할 수 있도록
    // Primitive type 대신 Wrapper Class 를 사용할 것.
    private Long uuid; // 유저 고유 아이디

    private String username;            // 유저 이름
    @NotEmpty
    private String userid;              // 유저 아이디
    @NotEmpty
    private String password;            // 비밀번호

    private String phone_number;        // 전화번호

    private UserAuthority authority;    // 유저 권한
    private LocalDateTime join_date;    // 가입일

    public static UserDTO toUserDTO(UserEntity entity){
        return UserDTO.builder()
                .uuid(entity.getUuid())
                .userid(entity.getUserid())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .phone_number(entity.getPhone_number())
                .join_date(entity.getJoin_date())
                .authority(entity.getAuthority())
                .build();
    }
}