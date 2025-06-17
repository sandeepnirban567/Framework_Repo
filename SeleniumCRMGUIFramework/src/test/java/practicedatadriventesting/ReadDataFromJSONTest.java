package practicedatadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONTest {

	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		
		// step 1' parse JSON physical file into java object using jsonParse class 
		
		   JSONParser parser = new JSONParser(); 
            Object obj = parser.parse(new FileReader("./src/test/resources/appCommonData.json"));
            
             // setp 2 Convert java object in to JSON Object using Down Casting 
                 JSONObject jObj= (JSONObject)obj;
            
               // step 3 then get the value from JSON file using key 
               System.out.println(jObj.get("url"));
               System.out.println(jObj.get("browser")); 
               System.out.println(jObj.get("username")); 
               System.out.println(jObj.get("password"));
               System.out.println(jObj.get("timeout"));
                
                
              
            
	}

}
