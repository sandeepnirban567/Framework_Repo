package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipledataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		  FileInputStream fis = new FileInputStream("./src/test/resources/testScriptdata.xlsx");
	       Workbook wb = WorkbookFactory.create(fis);
	                 Sheet sh = wb.getSheet("sheet1");
	                 // show list of all 
	                 
	                 
	                 int rowcount  = sh.getLastRowNum();
	                 for( int i=1;i<=rowcount;i++)
	                 {
	              //   for(int i=1; i<30;i++) {
	                        Row row = sh.getRow(i);
	                        // 1 row 
	                        String colum1data1 = row.getCell(0).toString();
	                        String colum1data2 = row.getCell(1).toString();
	                        
	                        System.out.println(colum1data1 +"\t"+colum1data2);
	                 }
	
                 wb.close();
	       }
	}


