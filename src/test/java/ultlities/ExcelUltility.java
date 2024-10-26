package ultlities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUltility {
	
	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell Cell;
	public CellStyle style;
	public FileOutputStream fo;
	public String path;
	
	public ExcelUltility (String path) {
		this.path = path;
		
	}
	
	public int getrowcount ( String xsheet) throws IOException {
		fi = new FileInputStream (path);
		workbook = new XSSFWorkbook(fi);
	sheet =	workbook.getSheet(xsheet);
	int rowcount =sheet.getLastRowNum();
	workbook.close();
	fi.close();
	return rowcount;
		
	}
	
	public int getcellcount ( String xsheet, int Rownum ) throws IOException {
		fi = new FileInputStream (path);
		workbook = new XSSFWorkbook(fi);
	sheet =	workbook.getSheet(xsheet);
 row = sheet.getRow(Rownum);
 int cellcount =row.getLastCellNum();
 workbook.close ();
 fi.close();
 return cellcount;
 	

}
	public String getCellData (String xsheet, int Rownum, int colnum) throws IOException {
		fi = new FileInputStream (path);
		workbook = new XSSFWorkbook(fi);
	sheet =	workbook.getSheet(xsheet);
 row = sheet.getRow(Rownum);
 Cell = row.getCell(colnum);
 DataFormatter formatter = new DataFormatter();
 String data;
 try {
	 data =formatter.formatCellValue(Cell);
 }
 catch (Exception e)
 {
	 data = "";
	 workbook.close();
	 fi.close();
	 return data;
 }
return data;
	}
}
 

