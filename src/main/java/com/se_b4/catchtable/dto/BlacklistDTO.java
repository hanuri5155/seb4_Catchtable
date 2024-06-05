package com.se_b4.catchtable.dto;

import com.se_b4.catchtable.entity.BlacklistEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder
public class BlacklistDTO {
    private Long uuid; // 유저 고유 아이디

    @NotEmpty
    private String username;            // 유저 이름
    @NotEmpty
    private String phone_number;        // 전화번호

    public static BlacklistEntity toBlacklistDTO(BlacklistEntity entity){
        return BlacklistEntity.builder()
                .uuid(entity.getUuid())
                .username(entity.getUsername())
                .phone_number(entity.getPhone_number())
                .build();
    }
}
