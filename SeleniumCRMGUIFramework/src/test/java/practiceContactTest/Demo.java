package practiceContactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		  FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata1.xlsx") ;
		 
		    Workbook wb = WorkbookFactory.create(fis);
		 
             Sheet sh = wb.getSheet("org");	
           Row row = sh.getRow(8);
           Cell cell = row.getCell(0);
             
             String pno= row.getCell(1).getStringCellValue();
      	   System.out.println(pno); 
      	   
          double num = row.getCell(2).getNumericCellValue();
       	   System.out.println(num); 
           Date date = row.getCell(3).getDateCellValue();
    	   System.out.println(date);  
       	   
      	   boolean bool = row.getCell(4).getBooleanCellValue();
    	   System.out.println(bool);  
    	   
   
  
        
                      

	}

}
