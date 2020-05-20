package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollections {
	
	public static void main(String[] args) {
		
		List<String> values = new ArrayList<String>();
		
		values.add("HCL");
		values.add("Wipro");
		values.add("Aspire Systems");
		values.add("CTS");
		
		values.size();
		
	    Collections.sort(values);
		
	    System.out.println(values);
			
	    
	    for(int i = values.size()-1 ; i>=0; i--) {
	    	System.out.println(values.get(i));
	    
	    }
		}
}
	
		
		
	


