package week3.day1;

public class MobilePhone {
	
	public void sendmessage() {
		System.out.println("send a message");
	}
	public void makecall() {
		System.out.println("make calls");
	}
	
	public void savecontact() {
		System.out.println("save your contacts");
	}

   public static void main(String[] args) {
	
	   MobilePhone object = new MobilePhone();
	   
	   object.savecontact();
	   object.sendmessage();
	   object.makecall();
	   
	   
}


}

