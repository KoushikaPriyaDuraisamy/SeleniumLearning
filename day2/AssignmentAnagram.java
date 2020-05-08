package week1.day2;

import java.util.Arrays;

public class AssignmentAnagram {

	public static void main(String[] args) {
		String t1 = "stops";
		String t2 = "potss";
		int len1 = t1.length();
		int len2 = t2.length();
		 if(len1==len2) {
			 
		char[] ch1 = t1.toCharArray();
		Arrays.sort(ch1);
		char[] ch2 = t2.toCharArray();      
		Arrays.sort(ch2);
       
        	
        for (int i =0; i<len1; i++) {
        	if(ch1[i]==ch2[i]) {
        		System.out.println("t1 and t2 are anagrams");
        	}
        	else
        	{
        		System.out.println("t1 and t2 are not anagrams");
        	}
        		
        	}
        }
        	}
		
	}

