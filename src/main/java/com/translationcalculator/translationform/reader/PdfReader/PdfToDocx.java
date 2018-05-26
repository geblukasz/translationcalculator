package com.translationcalculator.translationform.reader.PdfReader;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfToDocx {

    private String inputFilePath;
    private String outputFilePath;

    public PdfToDocx(String inputFilePath, String outputFilePath){
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

//    private static final String FILENAME = "D:\\java\\JavaDOCPytaniaRekrutacyjne.pdf";
//    private static final String FILENAME2 = "D:\\java\\dokument ze zdj.pdf";
//    private static final String OUTPUT = "D:\\java\\odzyskane\\dupa2.docx";

    public void readPdfFile() {
        try {
            generateDocFromPDF(inputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateDocFromPDF(String filename) throws IOException {
        try (XWPFDocument doc = new XWPFDocument()) {

            String pdf = filename;
            PdfReader reader = new PdfReader(pdf);
            PdfReaderContentParser parser = new PdfReaderContentParser(reader);

            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                TextExtractionStrategy strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
                String text = strategy.getResultantText();
                XWPFParagraph p = doc.createParagraph();
                XWPFRun run = p.createRun();
                run.setText(text);
                run.addBreak(BreakType.PAGE);
            }
            FileOutputStream out = new FileOutputStream(outputFilePath);
            doc.write(out);
            out.close();
            reader.close();
            doc.close();
        }
    }

}
