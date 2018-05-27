package com.translationcalculator.translationform.reader.PdfReader;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PDFImageExtractor {

    private String outputDirectory;
    private String intputFilePath;

    public PDFImageExtractor(String intputFilePath, String outputDirectory) {
        this.outputDirectory = outputDirectory;
        this.intputFilePath = intputFilePath;
    }



    public void extractImagesFromPdf() throws IOException {
//        FileStorageProperties storageProperties = new FileStorageProperties();
//        outputDirectory = storageProperties.getLocation();

//        String outputDirectory = "D:\\java\\odzyskane\\";
//        String inputDirestory = "D:\\java\\dokument ze zdj.pdf";
        PDDocument document = null;
        try {
            document = PDDocument.load(new File(intputFilePath));
            PDPageTree list = document.getPages();
            for (PDPage page : list) {
                PDResources pdResources = page.getResources();
                for (COSName c : pdResources.getXObjectNames()) {
                    PDXObject o = pdResources.getXObject(c);
                    if (o instanceof org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) {
                        File file = new File(outputDirectory + System.nanoTime() + ".png");
                        ImageIO.write(((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) o).getImage(), "png", file);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
        }


    }

}
