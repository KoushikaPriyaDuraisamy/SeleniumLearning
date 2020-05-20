package assignments;

public class KVB extends RBI{
	
	public void loadInterestRate(String personalLoan) {
		System.out.println("Personal loan Interest Rate - " + personalLoan + "%");
		
	}
	

	     public static void main(String[] args) {
	    	 
	    	 KVB obj = new KVB();
	    	 
	    	 
	    	 obj.loanInterestRate();
	    	 obj.loanInterestRate("2");
	    	 obj.loadInterestRate("10");
	
			
		}
}
