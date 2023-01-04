package week6;

import java.io.IOException;
//import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateLeadEXcel {
	public static String[][] readData(String filename) throws IOException {
		//workbook
		XSSFWorkbook wb=new XSSFWorkbook("data/"+filename+".xlsx");
		//sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		//row
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("No of Rows:"+lastRowNum);
		//coloumn
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("No of coloumn:"+lastCellNum);
		//in array
		String[][] data=new String[lastRowNum][lastCellNum];
		
		//get data from cell
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j]=stringCellValue;
				
			}
			}
		//close the work book
		wb.close();
		return data;
		
		
	}

}
