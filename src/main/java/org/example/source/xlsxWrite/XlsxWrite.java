package org.example.source.xlsxWrite;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Student;
import org.example.model.University;

import java.io.*;
import java.util.List;
import java.util.logging.Level;

import static org.example.Main.logger;

public class XlsxWrite {
    String resultFile = "C:/Users/icq80/IdeaProjects/Project_test_university/src/main/resources/InfoOut.xlsx";

    public XlsxWrite(boolean sheet1, boolean sheet2, List<Student> students, List<University> universities) {
        XSSFWorkbook createdBook = new XSSFWorkbook();
        if (sheet1) {
            new XlsxWriteSheet1(createdBook, students, universities);
        }
        ;
        if (sheet2) {
            new XlsxWriteSheet2(createdBook, students, universities);
        }
        ;
        try (FileOutputStream out = new FileOutputStream(new File(resultFile))) {
            createdBook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "InfoOut.xlsx ERROR");
        }
        logger.log(Level.INFO, "InfoOut.xlsx SUCCESS");
    }
}