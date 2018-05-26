package com.translationcalculator.translationform.reader;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MultiFileConverter {

    private MultipartFile filePath;

    public MultiFileConverter(MultipartFile filePath) {
        this.filePath = filePath;
    }

    public File convertMultiFile() throws IOException {

        File file = convert(filePath);



        return file;
    }

    private File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
