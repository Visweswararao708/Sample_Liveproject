package nov21;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Formatcell {

	public static void main(String[] args)throws Throwable {
		// get path of excel file
		FileInputStream fi = new FileInputStream("C:\\ExcelFiles\\sample.xlsx");
		// get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from file
		XSSFSheet ws = wb.getSheet("Emp");
		// count no of rows
		int rc = ws.getLastRowNum();
		System.out.println(rc);
		for(int i=1;i<=rc;i++) 
		{
			ws.getRow(i).createCell(4).setCellValue("pass");
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.BRIGHT_GREEN.getIndex());;
			font.setBold(true);
			ws.getRow(i).getCell(4).setCellStyle(style);
		}
		fi.close();

		FileOutputStream fo = new FileOutputStream("C:\\ExcelFiles\\result.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();





	}

}
