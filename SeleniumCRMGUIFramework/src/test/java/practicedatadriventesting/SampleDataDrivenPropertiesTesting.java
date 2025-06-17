package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenPropertiesTesting {

	public static void main(String[] args) throws IOException {
		
		// get the java representation of the physical file
		   FileInputStream fis= new FileInputStream("./src/test/resources/commandata.properties");
		   
		// used thge properties class , load all the key
		    Properties pobj= new Properties();
		    pobj.load(fis);    
		// get  the value on the the key 
		   System.out.println(pobj.getProperty("url"));
		    System.out.println(pobj.getProperty("browser"));
		    System.out.println(pobj.getProperty("username"));
		    System.out.println(pobj.getProperty("password"));
		    
		    
		    
		    

	}

}
