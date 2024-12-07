package nov20;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpecificRowData_AlternateWay {

	public static void main(String[] args)throws Throwable{
		// read path of excel
		FileInputStream fi = new FileInputStream("C:\\ExcelFiles\\sample.xlsx");
		// get workbook from the file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		// get sheet from the workbook
		XSSFSheet ws = wb.getSheet("Emp");
		// count no of rows
		int rc = ws.getLastRowNum();
		System.out.println("no of rows:::"+rc);
		// read any row
		XSSFRow row = ws.getRow(11);
		// read all cells from row
		XSSFCell c1 = row.getCell(0);
		XSSFCell c2 = row.getCell(1);
		XSSFCell c3 = row.getCell(2);
		XSSFCell c4 = row.getCell(3);
		String fname = c1.getStringCellValue();
		String mname = c2.getStringCellValue();
		String lname = c3.getStringCellValue();
		int eid = (int) c4.getNumericCellValue();
		System.out.println(fname+"   "+mname+"    "+lname+"    "+eid);
		fi.close();
		wb.close();






	}

}
