package week1.day2;

import java.util.Arrays;

public class ClassroomSessionFindLargest {

	public static void main(String[] args) {
		int[] num = new  int[6];
	

	num[0] = 3;
	num[1] = 2;
	num[2] = 11;
	num[3] = 4;
	num[4] = 6;
	num[5] = 7;
	
	Arrays.sort(num);
	
	
		System.out.println(num[num.length-2]);
	}

}
