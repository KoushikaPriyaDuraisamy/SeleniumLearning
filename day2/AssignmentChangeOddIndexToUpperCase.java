package week1.day2;

import java.util.Locale;

public class AssignmentChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		String str = "changeme";
		int len = str.length();
		char[] charArray = str.toCharArray();
		
		for (int i = 0; i<len; i++)
		{char ch = str.charAt(i);
			if(i%2==1){
		System.out.print(Character.toUpperCase(ch));
		}
			else
			{
				System.out.print(Character.toLowerCase(ch));
			
		
}
}
}
}