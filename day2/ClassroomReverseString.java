package week1.day2;

public class ClassroomReverseString {

	public static void main(String[] args) {
		String test = "feeling good";
		 char[] ch = test.toCharArray(); 
		 for (int i = ch.length-1; i>=0; i--) 
	            System.out.print(ch[i]); 
	    } 
	}
