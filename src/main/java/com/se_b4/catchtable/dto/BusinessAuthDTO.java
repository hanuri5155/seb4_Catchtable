package com.se_b4.catchtable.dto;

import com.se_b4.catchtable.entity.BusinessAuthEntity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder
public class BusinessAuthDTO {
    private Long uid; // 고유 아이디

    @NotNull
    private Long ouuid;            // 사업자 고유 아이디

    private String businessDetailsFile;        // 사업장 파일 경로 (pdf)

    public static BusinessAuthEntity toBusinessAuthDTO(BusinessAuthEntity entity){
        return BusinessAuthEntity.builder()
                .uid(entity.getUid())
                .ouuid(entity.getOuuid())
                .businessDetailsFile(entity.getBusinessDetailsFile())
                .build();
    }
}