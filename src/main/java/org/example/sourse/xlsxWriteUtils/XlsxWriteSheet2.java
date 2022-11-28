package org.example.sourse.xlsxWriteUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Statistics;
import org.example.model.Student;

import java.util.List;

import static org.example.sourse.XlsxReadUtils.loadStudentsFromFile;
import static org.example.sourse.XlsxReadUtils.loadUniversitiesFromFile;
import static org.example.sourse.xlsxWriteUtils.XlsxStatisticsUtil.createStatList2;

public class XlsxWriteSheet2 {
    XlsxWriteSheet2(XSSFWorkbook createdBook, String sourse) {
        XSSFSheet createdSheet = createdBook.createSheet("Второй");
//        здесь готовим коллекцию для статистики
        List<Statistics> dataList = createStatList2(loadStudentsFromFile(sourse), loadUniversitiesFromFile(sourse));

        int rowNum = 0;

        CellStyle style1 = XlsxStyler.createBoldRow(createdBook);

        Row row = createdSheet.createRow(rowNum);
        Cell cell0 = row.createCell(0);
        cell0.setCellStyle(style1);
        cell0.setCellValue("Название универа");

        Cell cell1 = row.createCell(1);
        cell1.setCellStyle(style1);
        cell1.setCellValue("Количество студентов");

        for (Statistics statistics : dataList) {
            createSheetHeader(createdSheet, ++rowNum, statistics);
        }
    }

    private static void createSheetHeader(XSSFSheet sheet, int rowNum, Statistics dataModel) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(dataModel.getUniversityNames());
        row.createCell(1).setCellValue(dataModel.getStudentsCnt());
    }
}
