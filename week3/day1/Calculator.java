package week3.day1;

public class Calculator {
	
	public void addtion(int a,int b) {
		System.out.println((a+b));
	}
	
  public void addition2(int c, int d, int e) {
	System.out.println((c+d+e));
	}


   public void multiplication(int f, int g){
	   System.out.println((f*g));
	}
   
  public void multiplication2(int h, double i){
	  System.out.println((h*i));
   }
  
   public void subtraction(int j, int k){
	   System.out.println((j-k)); 
   }
   
   public void subtration2(double l, double m){
	   System.out.println((l-m));
   }
   
    public void divide(int n, int o){
	   System.out.println((n/o));
   }
   
    public void divide2(double p, int q) {
    	System.out.println((p/q));
   }
    
    public static void main(String[] args) {
    	
    	Calculator cal = new Calculator();
    	
    	cal.addtion(10, 20);
    	cal.addition2(30, 40, 50);
    	cal.multiplication(2, 8);
    	cal.multiplication2(5, 12.25);
		cal.subtraction(20, 10);
		cal.subtration2(33.56, 22.12);
		cal.divide(56, 8);
		cal.divide2(25.55, 5);
		System.out.println();
	}
    
}
