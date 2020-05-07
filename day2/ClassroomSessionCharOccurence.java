package week1.day2;

public class ClassroomSessionCharOccurence {

	public static void main(String[] args) {
		String s1 =  "welcome to chennai people";
		int count = 0;
		int len = s1.length();
		
		char[] charArray = s1.toCharArray();
		for (int i = 0; i<len; i++) { 
				if(charArray[i]=='e')
					count++;
				}

		 System.out.println("Number of occurence is :" +  count++);
	}
}
	


	
	
	
	
	
	
	
	



