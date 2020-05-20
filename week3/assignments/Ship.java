package assignments;

public class Ship {
	
	public void shipName(String shipName) {
		
		System.out.println("Name of the Ship is " + shipName);
	}
	
	  public void shipbuiltYear(String shipbuiltYear){
		  System.out.println("Ship was built in the Year " + shipbuiltYear);
	  }
	
   public static void main(String[] args) {
	 
	    Ship Obj = new Ship();
	    
	    Obj.shipName("INS Jalashwa");
	    Obj.shipbuiltYear("1966");
	   
	    
}
}


