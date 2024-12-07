package nov20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CountRowsAndColumns {

	public static void main(String[] args) throws Throwable {
		// read path of excel
		FileInputStream fi =  new FileInputStream("C:\\\\ExcelFiles\\\\sample.xlsx");
		// get work from the file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		// get sheet from workbook
		XSSFSheet ws = wb.getSheet("Emp");
		//get first row from emp sheet
		XSSFRow row = ws.getRow(0);
		// count no of rows
		int rc = ws.getLastRowNum();
		// count no of cells in first row
		int cc = row.getLastCellNum();
		System.out.println("no of rows are:::"+rc);
		System.out.println("no of cells are::"+cc);
		fi.close();
		wb.close();

	}

}
