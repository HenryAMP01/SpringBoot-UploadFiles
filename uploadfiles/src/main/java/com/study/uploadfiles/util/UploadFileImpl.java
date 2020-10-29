package com.study.uploadfiles.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileImpl implements IUploadFileService {

    private static final String UPLOAD_PATH = "upload";

    public String saveFile(MultipartFile file) throws IOException {
        createUploadDirectory(); // Crea el directorio si no existe
        final String filename = getUniqueFileame(file);
        Files.write(getUploadPath().resolve(filename), file.getBytes());
        return filename;
    }

    @Override
    public void deleteFile(final String filename) throws IOException {
        File file = getUploadPath().resolve(filename).toFile();
        if(!file.delete()){
            throw new IOException("Ha ocurrido una excepción, archivo no existente o se encuentra corrupto");
        }
    }

    // Helpers methods

    private String getUniqueFileame(MultipartFile file) {
        StringBuilder filename = new StringBuilder();
        filename.append(UUID.randomUUID().toString());
        filename.append(".");
        filename.append(file.getOriginalFilename().split("\\.")[1]);
        return filename.toString();
    }

    private void createUploadDirectory() throws IOException {
        Path path = getUploadPath();
        if(!path.toFile().exists()){
            Files.createDirectory(path);
        }
    }

    private Path getUploadPath(){
        return Paths.get(UPLOAD_PATH).toAbsolutePath();
    }

}
