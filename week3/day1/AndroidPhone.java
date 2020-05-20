package week3.day1;

public class AndroidPhone extends MobilePhone{
	
	
	public void takevideo() {
		System.out.println("take videos");
	}
	
	public void connectwhatsapp() {
		System.out.println("connect to whatssapp");
	}
	
public static void main(String[] args) {
	
	AndroidPhone object = new AndroidPhone();
	
	object.takevideo();
	object.connectwhatsapp();
}
	
	
}
