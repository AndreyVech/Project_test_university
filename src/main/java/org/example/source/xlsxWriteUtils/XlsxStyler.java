package org.example.source.xlsxWriteUtils;

import org.apache.poi.ss.usermodel.*;


public class XlsxStyler {
    private XlsxStyler(){};
//        пока один стиль, хватит
    public static CellStyle createBoldRow(Workbook workbook){
        CellStyle styleBoldRow = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        styleBoldRow.setFont(font);
        styleBoldRow.setWrapText(true);
        styleBoldRow.setAlignment(HorizontalAlignment.CENTER);
        styleBoldRow.setVerticalAlignment(VerticalAlignment.CENTER);
        return styleBoldRow;
    }
}
