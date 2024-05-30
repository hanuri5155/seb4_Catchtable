package com.se_b4.catchtable.dto;

import java.time.LocalDateTime;
import com.se_b4.catchtable.authority.UserAuthority;
import com.se_b4.catchtable.entity.OwnerEntity;
import com.se_b4.catchtable.entity.UserEntity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class OwnerDTO extends UserDTO{

    public static OwnerDTO toOwnerDTO(OwnerEntity entity) {
        return OwnerDTO.builder()
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
