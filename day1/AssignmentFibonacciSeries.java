package week1.day1;

public class AssignmentFibonacciSeries {

	public static void main(String[] args) {
		int range = 10; 
		int n1 = 0; 
		int n2 = 1;

		  
		for (int i = 0; i<range; i++) 
		{	
			
	    System.out.println(n1+ " ");
		int sum = n1 + n2;
		n1 = n2;
		n2 = sum;
		
		}
	}
}
