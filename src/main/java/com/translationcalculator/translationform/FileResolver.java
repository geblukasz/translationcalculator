package com.translationcalculator.translationform;

import com.translationcalculator.translationform.config.ConfigYml;
import com.translationcalculator.translationform.reader.MultiFileConverter;
import com.translationcalculator.translationform.reader.PdfReader.PDFImageExtractor;
import com.translationcalculator.translationform.reader.TextReader.DocxReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileResolver {


    private MultipartFile multipartFile;

    public FileResolver(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public void resolve() throws IOException {


        String fileFormat = multipartFile.getOriginalFilename().split("\\.")[1];
        System.out.println(fileFormat);

        MultiFileConverter multiFileConverter = new MultiFileConverter(multipartFile);
        File convertedFile = new File(multiFileConverter.convertMultiFile().toPath().toString());


        ConfigYml configYml = new ConfigYml();
        configYml.readYamlFile();

        switch (fileFormat) {
            case "docx":
                System.out.println("Found docx file");
                DocxReader docxReader = new DocxReader();
                docxReader.readDocxFile(convertedFile);
                break;
            case "pdf":
                System.out.println("PDF");
                PDFImageExtractor extractor = new PDFImageExtractor(convertedFile.getPath(), configYml.getPath().toString());
                extractor.extractImagesFromPdf();
                break;
            case "doc":
                System.out.println("DOC");
                break;
            default:
                System.out.println("could not resolve a file");
        }
    }
}