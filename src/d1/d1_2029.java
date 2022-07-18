package d1;

import java.util.Scanner;

public class d1_2029 {

	public static void main(String[] args) {
		int T,n1,n2;
		
		Scanner sc = new Scanner(System.in);
		
		T=sc.nextInt();
		for(int i=1;i<=T;i++) {
			n1=sc.nextInt();
			n2=sc.nextInt();
			
			System.out.println("#"+i+" "+(n1/n2)+" "+(n1%n2));
		}
		
		
	}

}
