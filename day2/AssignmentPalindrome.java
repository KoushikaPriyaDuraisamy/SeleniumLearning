package week1.day2;

public class AssignmentPalindrome {

	public static void main(String[] args) {
		String str = "madam";
		String rev = " ";
		int len = str.length();
		char [] ch = str.toCharArray();
		
		for (int i =len-1; i>= 0; i--)
		rev = rev+ str.charAt(i);
		
		  if(str.equals(rev))
		  { 
			  System.out.println("The string is palindrome.");
			  }
		
		  else { System.out.println("The string is not palindrome."); }
		 
		  
		  }
	}


