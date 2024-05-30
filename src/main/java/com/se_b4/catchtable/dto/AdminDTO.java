package com.se_b4.catchtable.dto;
import java.time.LocalDateTime;
import com.se_b4.catchtable.authority.UserAuthority;
import com.se_b4.catchtable.entity.AdminEntity;
import com.se_b4.catchtable.entity.UserEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class AdminDTO extends UserDTO{

    public static AdminDTO toAdminDTO(AdminEntity entity) {
        return AdminDTO.builder()
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
