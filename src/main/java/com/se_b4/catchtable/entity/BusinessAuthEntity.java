package com.se_b4.catchtable.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder
public class BusinessAuthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;              // 고유 아이디

    private Long ouuid;            // 사업자 고유 아이디

    private String businessDetailsFile;  // 사업장 정보 파일이름
}
