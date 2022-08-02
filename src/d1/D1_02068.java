package d1;

import java.util.Scanner;

public class D1_02068 {

	public static void main(String[] args) {
		int T;
		int[] arr = new int[10];
		
		
		Scanner sc = new Scanner(System.in);
		
		T=sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int max=Integer.MIN_VALUE;
			for(int j=0;j<10;j++) {
				arr[j]=sc.nextInt();
				if(max<arr[j]) max=arr[j];
			}
			
			System.out.println("#"+i+" "+max);
		}

	}

}
