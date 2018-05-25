package com.translationcalculator.translationform.Reader;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;

public class DocReader {

    public void czytaj(File file) {
        try {
//            FileInputStream fis = new FileInputStream("D:\\java\\JavaPytaniaRekrutacyjne.docx");
            FileInputStream fis = new FileInputStream(file.getName());
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            StringBuilder builder = new StringBuilder();
            builder.append(extractor.getText());
            System.out.println(builder);
            System.out.println("Liczba znakow: " + builder.toString().length());


            System.out.println(extractor.getText());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}