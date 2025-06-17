package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectExecutiveQueryDBTest {

	public static void main(String[] args) throws SQLException { 
		
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
			 System.out.println(resultset.getString(1)+"  "+(resultset.getString(2)+ "  " +(resultset.getString(3))));	 
		 }
		      // 5 closed the connection 
      conn.close();
	}

}
	