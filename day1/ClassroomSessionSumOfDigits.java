package week1.day1;

public class ClassroomSessionSumOfDigits {

public static void main(String args[]){
	
    int i = 158;
    int r = 0;
    int sum = 0;
    
    while (i>0){
    	r = i%10;
    	sum = r + sum;
    	i = i/10; 
    }
    
    
    System.out.println(sum);
}
}