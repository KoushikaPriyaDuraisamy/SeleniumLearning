package week3.day2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class RemoveDuplicates {

	public static void main(String[] args) {
		
		String str = "PayPal India";
	 
		
		char[] ch = str.toCharArray(); 
		
		Set<Character> charset = new LinkedHashSet<Character>();
  
		Set<Character> dupcharset = new LinkedHashSet<Character>();
		
		for (Character eachchar : ch) {
			if(!charset.add(eachchar)) {
				dupcharset.add(eachchar);
			}
		}
		
		/*
		 * for (Character character : dupcharset) {
		 * 
		 * System.out.print(character); }
		 */
		
		
		  charset.removeAll(dupcharset);
		  
		  for (Character temp : charset) 
	              if(temp!=' '){
				 System.out.print(temp);
			}
		
		  
		 
		 
		
		}
		
	}


