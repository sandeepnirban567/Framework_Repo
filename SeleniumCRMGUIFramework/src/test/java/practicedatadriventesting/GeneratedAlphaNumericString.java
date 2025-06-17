package practicedatadriventesting;

public class GeneratedAlphaNumericString {

	public static void main(String[] args) {
		
		
		 int n = 20;
		 //   choose a character random from the string
		 String AlphaNumericstring = "asddfghjkl123456789944446666661111aaasdfgjjjjjklqwwertyu";
		 // create String buffer size of AlphaNumericstring
		 StringBuilder sb = new  StringBuilder(n);
		 for(int i = 0; i< n;i++) {
			 // generate a random number between 0to AlphaNumericstring variable length
			 int index = (int)(AlphaNumericstring.length()*Math.random());
			 
			 //  add character one by one in end of sb
			 sb.append(AlphaNumericstring.charAt(index));
		 }
            System.out.println(sb);          
	}

}
