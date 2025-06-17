package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackOrWriteToExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// write data
		FileInputStream fis = new FileInputStream( "./src/test/resources/testScriptdata.xlsx" );
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		
		Row row = sh.createRow(2);
	    Cell cell = row.createCell(10);
	    
	    cell.setCellValue("PASS") ;
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testScriptdata.xlsx") ;
		wb.write(fos);
		wb.close(); 
	   }
    }
