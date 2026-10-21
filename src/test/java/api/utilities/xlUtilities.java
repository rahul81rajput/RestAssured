package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlUtilities {


	
	    static String path = "./testData/REST_Assured_User_Data.xlsx";

	    public static int getRowCount(String sheetName) throws IOException {

	        FileInputStream fis = new FileInputStream(path);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getLastRowNum();

	        workbook.close();
	        fis.close();

	        return rowCount;
	    }

	    public static int getCellCount(String sheetName, int rowNum)
	            throws IOException {

	        FileInputStream fis = new FileInputStream(path);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);

	        int cellCount = row.getLastCellNum();

	        workbook.close();
	        fis.close();

	        return cellCount;
	    }

	    public static String getCellData( String sheetName, int rowNum, int colNum)throws IOException {

	        FileInputStream fis = new FileInputStream(path);
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);

	        DataFormatter formatter = new DataFormatter();
	        String cellData = formatter.formatCellValue(
	                row.getCell(colNum));

	        workbook.close();
	        fis.close();

	        return cellData;
	    
	}
	
}
