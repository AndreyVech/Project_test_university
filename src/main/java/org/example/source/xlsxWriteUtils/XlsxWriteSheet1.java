package org.example.source.xlsxWriteUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.comparatorIn.utils.ComparatorUtils;
import org.example.enums.ComparatorTypeUniversity;
import org.example.model.Statistics;

import java.util.List;
import java.util.logging.Level;

import static org.example.Main.logger;
import static org.example.source.XlsxReadUtils.loadStudentsFromFile;
import static org.example.source.XlsxReadUtils.loadUniversitiesFromFile;
import static org.example.source.xlsxWriteUtils.XlsxStatisticsUtil.createStatList1;

public class XlsxWriteSheet1 {
    XlsxWriteSheet1(XSSFWorkbook createdBook, String sourse) {
        XSSFSheet createdSheet = createdBook.createSheet("Главный");
//        здесь готовим коллекцию для статистики
        List<Statistics> dataList = createStatList1(loadStudentsFromFile(sourse), loadUniversitiesFromFile(sourse));
        int rowNum = 0;

        CellStyle style1 = XlsxStyler.createBoldRow(createdBook);

        Row row = createdSheet.createRow(rowNum);
        Cell cell0 = row.createCell(0);
        cell0.setCellStyle(style1);
        cell0.setCellValue("Профиль обучения");

        Cell cell1 = row.createCell(1);
        cell1.setCellStyle(style1);
        cell1.setCellValue("Средний балл");

        Cell cell2 = row.createCell(2);
        cell2.setCellStyle(style1);
        cell2.setCellValue("Количество студентов");

        Cell cell3 = row.createCell(3);
        cell3.setCellStyle(style1);
        cell3.setCellValue("Количество университетов");

        Cell cell4 = row.createCell(4);
        cell4.setCellStyle(style1);
        cell4.setCellValue("Названия университетов");

        for (Statistics statistics : dataList) {
            createSheetHeader(createdSheet, ++rowNum, statistics);
        }
        logger.log(Level.INFO, "SUCCESS");

    }

    private static void createSheetHeader(XSSFSheet sheet, int rowNum, Statistics dataModel) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(dataModel.getStudyProfile().toString());
        row.createCell(1).setCellValue(dataModel.getAvgScore());
        row.createCell(2).setCellValue(dataModel.getStudentsCnt());
        row.createCell(3).setCellValue(dataModel.getUniversityCnt());
        row.createCell(4).setCellValue(dataModel.getUniversityNames());
    }
}
