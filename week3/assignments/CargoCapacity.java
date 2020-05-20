package assignments;

public class CargoCapacity extends Ship{
	
	public void shipcapacity(int tons) {
		System.out.println("Capacity of the ship is " + tons + " tonnes");
		
	}

	     public static void main(String[] args) {
			
	    	 CargoCapacity obj = new CargoCapacity();
	    	 
	    	 
	    	 obj.shipName("INS Jalashwa");
	    	 obj.shipbuiltYear("1966");
	    	 obj.shipcapacity(16600);
	    	 
		}
	
}
