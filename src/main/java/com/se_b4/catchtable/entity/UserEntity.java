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
@AllArgsConstructor
@SuperBuilder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;              // 유저 고유 아이디

    @Column(unique = true)
    private String userid;          // 유저 아이디

    private String username;        // 유저 이름
    private String password;        // 비밀번호
    private String phone_number;    // 전화번호
    private LocalDateTime join_date;// 가입일

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserAuthority authority;// 유저 권한

    // User 엔티티가 DB 에 저장되기 직전에 값을 생성
    @PrePersist
    protected void onCreate() {
        join_date = LocalDateTime.now(); // 현재 시간을 가입 날짜로 설정
    }
}