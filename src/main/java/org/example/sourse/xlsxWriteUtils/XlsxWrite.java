package org.example.sourse.xlsxWriteUtils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class XlsxWrite {
    String sourse = "";
    String resultFile = "C:/Users/icq80/IdeaProjects/Project_test_university/src/main/resources/InfoOut.xlsx";
    boolean sheet1;
    boolean sheet2;

    public XlsxWrite(String sourse, boolean sheet1, boolean sheet2) {
        XSSFWorkbook createdBook = new XSSFWorkbook();
        this.sourse = sourse;
        if (sheet1) {
            new XlsxWriteSheet1(createdBook, sourse);
        }
        ;
        if (sheet2) {
            new XlsxWriteSheet2(createdBook, sourse);
        }
        ;
        try (FileOutputStream out = new FileOutputStream(new File(resultFile))) {
            createdBook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
    }

    ;
}