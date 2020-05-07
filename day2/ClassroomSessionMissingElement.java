package week1.day2;

import java.util.Arrays;

public class ClassroomSessionMissingElement {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,7,6,8};
		int sum =0;
		
	    Arrays.sort(num);
	    
	    for (int i=1; i<num.length; i++)
	    {
	    	sum=sum+num[i];
	    	System.out.println(i);
	    }
	    
	
	}
}
