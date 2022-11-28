package org.example.sourse.xlsxWriteUtils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFColorScaleFormatting;


public class XlsxStyler {
    private XlsxStyler(){};
//        пока один стиль, хватит
    public static CellStyle createBoldRow(Workbook workbook){
        CellStyle styleBoldRow = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 15);
        styleBoldRow.setFont(font);
        styleBoldRow.setAlignment(HorizontalAlignment.CENTER);
        styleBoldRow.setVerticalAlignment(VerticalAlignment.CENTER);
        return styleBoldRow;
    }
}
