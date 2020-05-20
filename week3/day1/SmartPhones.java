package week3.day1;

public class SmartPhones extends AndroidPhone{
	
	public void takevideo() {
		System.out.println("take new design videos");
	}
	
	public static void main(String[] args) {
		
		SmartPhones object = new SmartPhones();
		
		object.connectwhatsapp();
		object.makecall();
		object.savecontact();
		object.sendmessage();
		object.takevideo();
		
	}
}
