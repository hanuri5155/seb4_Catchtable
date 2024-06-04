package com.se_b4.catchtable.service;

import com.se_b4.catchtable.dto.UploadFile;
import lombok.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStoreService {

    // 상대 경로 말고 절대 경로 사용할것 (환경에 따라 수정하기)
    private String fileDir = "G:\\Projects\\Deu\\3-junior\\SE\\seb4_Catchtable\\seb4_Catchtable\\src\\main\\resources\\static\\file\\";

    public String getFullPath(String filename) { //파일이름 받아서 fullpath를 반환
        return fileDir + filename; // 디렉토리에 파일이름이 합쳐짐
    }

//    // 루프를 돌면서 multipartFile 이 비어있지 않으면 실행하여 storeFileResult 에 넣어서 결과 반환
//    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException { // 여러 개 업로드시 사용
//        List<UploadFile> storeFileResult = new ArrayList<>(); // 업로드 파일이 계속 생성이 되기 때문에 담아줘야 함
//        for (MultipartFile multipartFile : multipartFiles) {
//            if (!multipartFile.isEmpty()) { // multipartFile 이 비어있지 않으면!
//                storeFileResult.add(storeFile(multipartFile));
//                // 위 코드를 두줄로 하면
//                UploadFile uploadFile = storeFile(multipartFile);
//                storeFileResult.add(uploadFile);
//            }
//        }
//        return storeFileResult;
//    }

    // MultipartFile을 받아서 파일을 저장한 다음에 파일 경로 반환
    public String storeFile(MultipartFile multipartFile) throws IOException { // 한 개 업로드
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename(); // 사용자가 업로드한 파일이름
        String storeFileName = createStoreFileName(originalFilename); // 서버에 저장하는 파일명(uuid+.+확장자명)

        multipartFile.transferTo(new File(getFullPath(storeFileName))); // 디렉토리에 파일이름이 합쳐진 것이 File로 만들어지고
        return getFullPath(storeFileName); // 파일경로 반환
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
