package d2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_01954 {
	static int[][] snail;
	static int size;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			size=sc.nextInt();
			snail= new int[size][size];
			
			int num=1;
			int [][] deltas= {{0,1},{1,0},{0,-1},{-1,0}};
			int r=0,c=0,temp=size;
			snail[0][0]=1;
			while(true) {
				for(int i=0;i<size-1;i++) {
					int nr=r+deltas[0][0];
					int nc=c+deltas[0][1];
					
					if(isIn(nr,nc) && num<=temp*temp) {
						num++;
						snail[nr][nc]=num;
						r=nr;
						c=nc;
					}
					
				}
				
				for(int i=0;i<size-1;i++) {
					int nr=r+deltas[1][0];
					int nc=c+deltas[1][1];
					
					if(isIn(nr,nc) && num<=temp*temp) {
						num++;
						snail[nr][nc]=num;
						r=nr;
						c=nc;
					}
				}
				
				for(int i=0;i<size-1;i++) {
					int nr=r+deltas[2][0];
					int nc=c+deltas[2][1];
					
					if(isIn(nr,nc)&& num<=temp*temp) {
						num++;
						snail[nr][nc]=num;
						r=nr;
						c=nc;
					}
				}
				
				for(int i=0;i<size-2;i++) {
					int nr=r+deltas[3][0];
					int nc=c+deltas[3][1];
					
					if(isIn(nr,nc)&& num<=temp*temp) {
						num++;
						snail[nr][nc]=num;
						r=nr;
						c=nc;
					}
				}
				size--;
				
				if(size==0) break;
			}
			
			
			System.out.printf("#%d%n",t);
			
			for(int r1=0;r1<temp;r1++) {
				for(int c1=0;c1<temp;c1++) {
					System.out.printf("%d ",snail[r1][c1]);
				}
				System.out.println();
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<size && c<size && snail[r][c]==0;
	}

}
