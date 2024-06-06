package com.se_b4.catchtable.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Component
public class FileStoreService {

    public static String GetAbsoluteRoot()
    {
        return Path.of("src/main/resources/static/download").toAbsolutePath().toString() + '\\';
    }

    public String getFullPath(String filename)
    { //파일이름 받아서 fullpath를 반환
        return FileStoreService.GetAbsoluteRoot() + filename; // 디렉토리에 파일이름이 합쳐짐
    }

    // MultipartFile을 받아서 파일을 저장한 다음에 파일 경로 반환
    public String storeFile(MultipartFile multipartFile) throws IOException { // 한 개 업로드
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename(); // 사용자가 업로드한 파일이름
        String storeFileName = createStoreFileName(originalFilename); // 서버에 저장하는 파일명(uuid+.+확장자명)

        multipartFile.transferTo(new File(getFullPath(storeFileName))); // 디렉토리에 파일이름이 합쳐진 것이 File로 만들어지고
        return storeFileName; // 서버에 저장하는 파일명 반환
    }

    private String createStoreFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString(); // 서버에 저장하는 파일명(uuid)
        return uuid + "." + ext; // ext : 확장자명
    }

    private String extractExt(String originalFilename) { // 확장자명 꺼내기
        int pos = originalFilename.lastIndexOf("."); // 위치를 가져온다.
        return originalFilename.substring(pos + 1); // . 다음에 있는 확장자명 꺼냄
    }
}