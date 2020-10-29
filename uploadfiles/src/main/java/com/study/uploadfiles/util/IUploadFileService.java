package com.study.uploadfiles.util;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

    public String saveFile(MultipartFile file) throws IOException;

    public void deleteFile(String filename) throws IOException;

    
}
