package com.translationcalculator.translationform;

import com.translationcalculator.translationform.Reader.DocReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFile {

    public static void main(String[] args) throws IOException {


    }


    private MultipartFile filePath;

    public TestFile(MultipartFile filePath) {
        this.filePath = filePath;
    }

    public void readFile() throws IOException {

        File file = convert(filePath);

        DocReader docReader = new DocReader();
        docReader.czytaj(file);

        String content = new String(filePath.getBytes());

//        System.out.println(content);


        String fileName = filePath.getOriginalFilename();

    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
