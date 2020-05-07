package week1.day2;

public class AssignmentRemoveDuplicates {

	public static void main(String[] args) {
		String str = "We learn java basics as part of java sessions in java week1";	
		int count = 0;
		int len = str.length();
		String[] chararray = str.split("");
		
		for(int i =0;i<len; i++){
		for (int j = i+1; j < len; j++) {
		if(chararray[i].equals(chararray[j]))	
		count = count+1;
		if(count>0)
		
		System.out.println(chararray[j].replaceAll( " ", " "));
		
		}
		}
	for (String string : chararray ) {
		if(!string.equals(""))
			System.out.println(string + " ");
	}
	}
}