package week1.day1;

public class AssignmentArmstrongNumber {

	public static void main(String[] args) {
		int n=371;
		
		int cal =0; 
		int rem = 0;
		int original =0;
		
		original = n;
		while(n>0) {
			rem = n%10;
			
			n=n/10;
			
			cal=cal+(rem*rem*rem);
		}
		if (original==cal)
			System.out.println("It is armstrong number");
		
		else
			System.out.println("It is not armstrong number");
	}

}
