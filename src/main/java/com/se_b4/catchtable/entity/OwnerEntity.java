package com.se_b4.catchtable.entity;

import com.se_b4.catchtable.authority.UserAuthority;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder
public class OwnerEntity extends UserEntity{
    public OwnerEntity(Long uuid, String userid, String username, String password, String phone_number, LocalDateTime join_date, UserAuthority authority) {
        super(uuid, userid, username, password, phone_number, join_date, authority);
    }
}
