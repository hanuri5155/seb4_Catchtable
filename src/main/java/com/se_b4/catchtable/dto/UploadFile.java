package com.se_b4.catchtable.dto;

import lombok.Data;

@Data
public class UploadFile { // 업로드 파일명과 저장할 파일명은 분리(겹치면 덮어씌워지기 때문)
    private String uploadFileName;
    private String storeFileName;

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}