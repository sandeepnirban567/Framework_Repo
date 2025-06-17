package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEndDB {

	     @Test
	    public void projectCheckTest() throws Throwable { 
	    	
	   //  String  expectedProjectName = "FB_1"; 
	    	 String  expectedStatus = "Active";
	    	 boolean flag = false;
	    	 //step 1 load /register database driver;
	 		
	 		Driver driverref = new Driver();
	 		DriverManager.registerDriver(driverref);
	 		// 2 connect to data base 
	 		// jdbc:mysql://localhost:3306/projects
	 		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
	 		System.out.println("============Done-==================");
	 		// 3 create sql statement object 
	 		  Statement stat = conn.createStatement();
	 		// 4 execute select query and get  the result 
	 		 ResultSet resultset = stat.executeQuery("select * from project");
	 		 
	 		 while(resultset.next()) {
	 	//		  String actprojectName = resultset.getString(4);
	 		//	  System.out.println(actprojectName);
	 			  String Status  = resultset.getString(4);
	 		 	  
	 			  if(expectedStatus.equals(Status))
	 			  {
	 				 flag = true;
	 				 System.out.println(expectedStatus + " is   PASS");
	 				 
	 			  }
	 		 }    
	 		 if(flag == false)
	 		 {
	 			 System.out.println(expectedStatus +"  is not avaliable");
	 		 }
	     } 
}
   
