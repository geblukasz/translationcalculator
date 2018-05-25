package com.translationcalculator.translationform;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFile {

    public static void main(String[] args) throws IOException {


    }


    private MultipartFile filePath;

    public TestFile(MultipartFile filePath) {
        this.filePath = filePath;
    }

    public void readFile() throws IOException {


        String content = new String(filePath.getBytes());

        System.out.println(content);


        String fileName = filePath.getOriginalFilename();

    }
}
