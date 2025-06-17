package practicedatadriventesting;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterCMDTest {
	// download maven , 
	// https://maven.apache.org/download.cgimj 
	@Test
    public void runtimeparameter() {
		
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		// 
    	System.out.println("Env Data==>URL====>"+URL);
    	System.out.println("Browser Data==>URL====>"+BROWSER);
    	System.out.println("username Data==>URL====>"+USERNAME);
    	System.out.println("password Data==>URL====>"+PASSWORD);
    }

}
