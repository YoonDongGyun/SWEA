package d1;

import java.util.Scanner;

public class D1_01936 {

	public static void main(String[] args) {
		int A,B;
		
		Scanner sc=new Scanner(System.in);
		
		A=sc.nextInt();
		B=sc.nextInt();
		
		switch(A) {
		case 1:
			if(B==2) System.out.println("B");
			else if (B==3) System.out.println("A");
			break;
			
		case 2:
			if(B==1) System.out.println("A");
			else if (B==3) System.out.println("B");
			break;
			
		case 3:
			if(B==1) System.out.println("B");
			else if(B==2)System.out.println("A");
			break;
		}
	}

}
