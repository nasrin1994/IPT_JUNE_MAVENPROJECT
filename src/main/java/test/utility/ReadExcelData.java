package test.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadExcelData {

    public static String getParticularData(int rows, int column) {
        String data=null;
        try {
            File file = new File("J:\\javaRead.xlsx");
            Workbook wb = new XSSFWorkbook(file);
            Sheet sheet = wb.getSheet("Sheet1");
            Row row = sheet.getRow(rows);
            Cell cell = row.getCell(column);

            DataFormatter format = new DataFormatter();
            data = format.formatCellValue(cell);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}


