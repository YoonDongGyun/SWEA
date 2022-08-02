package d1;

import java.util.Scanner;

public class D1_02025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num,sum=0;
		Scanner sc = new Scanner(System.in);
		
		num=sc.nextInt();
		for(int i=1;i<=num;i++) {
			sum+=i;
		}
		
		System.out.println(sum);
	}

}
