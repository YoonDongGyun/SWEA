package d1;

import java.util.Scanner;

public class D1_01933 {

	public static void main(String[] args) {
		int N;
		
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		
		for(int i=1;i<=N;i++) {
			if(N%i==0) System.out.printf("%d ",i);
		}
	}

}
