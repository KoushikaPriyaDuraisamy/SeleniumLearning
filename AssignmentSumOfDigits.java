package week1.day2;

public class AssignmentSumOfDigits {

	public static void main(String[] args) {
		String str = "Tes12Le79af65";
		int sum = 0;
		int len = str.length();
		
		for (int i = 0; i <len; i++) 
		{
			
			
			if(Character.isDigit(str.charAt(i)))
			{
				sum = sum + Character.getNumericValue(str.charAt(i));
				
			}
			
		}
	 System.out.println(sum);
	}

}
