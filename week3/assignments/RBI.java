package assignments;

public class RBI {
	
	public void loanInterestRate() {
		System.out.println("Loan Interest Rate for Urban - 8%");
	}
	
	public void loanInterestRate(String agriculture) {
		System.out.println("Loan Interest Rate for Agriculture - " + agriculture + "%");
		
	}

	public static void main(String[] args) {
		
		RBI obj = new RBI();
		obj.loanInterestRate();
		obj.loanInterestRate("2");
		
		
	}
	
}
