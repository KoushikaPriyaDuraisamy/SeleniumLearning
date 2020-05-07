package week1.day2;

public class AssignmentReverseEvenwords {

	public static void main(String[] args) {
		 String str="I am a software tester"; 
		 String [] chararray = str.split(" ");
		 int len = str.length();
		 
		 for (int i=0; i<len; i++) {
			if(i%2==1)	{
				 char[] ch = str.toCharArray();
				 for(int j= len-1; j>=0; j--)
				 {
					 System.out.print(ch[j]);
				 }
			}
		 
			else
			{
			 System.out.print(" " + str.charAt(i) + " ");
				
			 }
	}
}
}			
		