package com.se_b4.catchtable.controller;

import com.se_b4.catchtable.entity.BusinessAuthEntity;
import com.se_b4.catchtable.service.BusinessApprovalService;
import com.se_b4.catchtable.service.FileStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admins")
public class BusinessApprovalController {
    private final BusinessApprovalService businessApprovalService;

    @GetMapping("/BusinessApprovalPage")
    public String BusinessApprovalPage(Model model) {
        List<BusinessAuthEntity> businessAuthEntityList = businessApprovalService.BusinessApproval();
        model.addAttribute("businessAuthEntityList", businessAuthEntityList);
        return "admins/BusinessApprovalPage";
    }

    @GetMapping("/admins/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName)
    {
        String path = FileStoreService.GetAbsoluteRoot() + fileName;

        try
        {
            Resource resource = new FileSystemResource(path);

            if(resource.exists() || resource.isReadable())
            {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }
            else
            {
                throw new RuntimeException("Could not read the file!");
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}