package assignments;

public class CruiseShip extends CargoCapacity {

	public void maximumPassengers(int count) {
		System.out.println("Ship can accomodate the mininum of " + count + " passangers");
	}
	
	public void shipcategory(String category) {
		System.out.println("CruiseShip category is  " + category);
	}
	
	
	 public static void main(String[] args) {
		
		 CruiseShip ship = new CruiseShip();
		 
		 
		 ship.shipName("INS Jalashwa");
		 ship.shipbuiltYear("1966");
		 ship.shipcapacity(16600);
		 ship.maximumPassengers(1200);
		 ship.shipcategory("Luxury");
		 
		 
	}
}
