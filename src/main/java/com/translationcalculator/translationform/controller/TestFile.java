package com.translationcalculator.translationform.controller;

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

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

    }
}
