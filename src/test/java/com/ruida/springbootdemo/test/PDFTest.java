package com.ruida.springbootdemo.test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

/**
 * @author Chen.J.Y
 * @date 2021/7/12
 */
public class PDFTest {

    public static void main(String[] args) throws IOException {
        //Creating PDF document object
        PDDocument document = new PDDocument();
        for (int i=0; i<10; i++) {
            //Creating a blank page
            PDPage blankPage = new PDPage();
            //Adding the blank page to the document
            document.addPage( blankPage );
        }
        //Saving the document
        document.save("D:/pdf/test.pdf");
        System.out.println("PDF created");
        //Closing the document
        document.close();
    }
}
