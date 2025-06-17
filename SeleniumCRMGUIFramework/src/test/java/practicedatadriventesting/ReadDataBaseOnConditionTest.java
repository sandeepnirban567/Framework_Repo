package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBaseOnConditionTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//   data is avaliable OR NOT	in that list
       String  data = " ";
       String  data1 = " ";
       String  data2= " ";
       String  data3 = " ";
       String  data4 = " ";
       String  data5 = " ";
		String  expectedTestId = "tc_02";
		
		boolean flag= false;
		
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptdata.xlsx");
	       Workbook wb = WorkbookFactory.create(fis);
	                   Sheet sh = wb.getSheet("Sheet2");
	                        Row row = sh.getRow(1);
	                        int rowcount = sh.getLastRowNum();
             for(int i =0 ;i<rowcount ; i++)
             {
            	 try {
            	  data = sh.getRow(i).getCell(0).toString();
            	  if(data.equals(expectedTestId))
            	  {
            		  flag=true;
            		  data1 = sh.getRow(1).getCell(1).toString();
            		  data2 = sh.getRow(2).getCell(2).toString();
            		  data3 = sh.getRow(3).getCell(3).toString();
            	  }
            	 }catch(Exception e) {}
            	 System.out.println(data);
            	 if(flag == true)
            	 {
            		 System.out.println(data1);
            		 System.out.println(data2);
            		 System.out.println(data3);
            	 }
            	 else
            	 {
            		 System.out.println(expectedTestId + " data is not available");
            	 }
             }
	}
	
   }
