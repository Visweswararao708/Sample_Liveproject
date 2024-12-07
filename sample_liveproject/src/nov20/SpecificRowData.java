package nov20;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpecificRowData {

	public static void main(String[] args)throws Throwable {
		// read path of excel
		FileInputStream fi = new FileInputStream("C:\\ExcelFiles\\sample.xlsx");
		// get woorkbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		// get sheet from workbook
		XSSFSheet ws = wb.getSheet("Emp");
		// count no of rows
		int rc = ws.getLastRowNum();
		System.out.println("no of rows:::"+rc);
		// print specific row cell data
		String fname = ws.getRow(5).getCell(0).getStringCellValue();
		String mname = ws.getRow(10).getCell(1).getStringCellValue();
		String lname = ws.getRow(4).getCell(2).getStringCellValue();
		int eid = (int) ws.getRow(7).getCell(3).getNumericCellValue();
		System.out.println(fname+"   "+mname+"    "+lname);
		fi.close();
		wb.close();


	}

}
