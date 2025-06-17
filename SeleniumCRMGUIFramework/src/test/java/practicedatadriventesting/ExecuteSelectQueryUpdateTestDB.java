package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryUpdateTestDB {

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
			// 4 execute select query and get  the result  IMP duplicate not allowed in the  
                int result = stat.executeUpdate("insert into project values ('200','meetu','1602200000','Done','2025-02-11','T-SDET');"); 
                  System.out.print(result);
                       
	}

}
