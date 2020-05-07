package week1.day2;

import java.util.Arrays;

public class ClassroomSessionPrintDuplicates {

	public static void main(String[] args) {
		int[] num = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		
		//int [] num= {1,4,5,6,7,2,4,2,5,6,8,0};
		
		int count = 0;
		Arrays.sort(num);
		
	//System.out.println(num.length);
		
		  for (int i=0; i <num.length-1; i++)
		  { 
			  for (int j = i+1; j<num.length; j++)
			  {
		 if(num[i]==num[j]) { System.out.println(num[j]); 
		 } 
		 }
	
		 }
		 
	}

}
