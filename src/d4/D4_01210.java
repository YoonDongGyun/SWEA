package d4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D4_01210 {
	
	static BufferedReader input;
	static StringTokenizer tokens;
	static String[][] ladder;
	static final int SIZE = 100;
	static int r,c,pass;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<10;i++) {
			int test_case=Integer.parseInt(input.readLine());
			ladder=new String[SIZE][SIZE];
			
			 for(int r=0;r<SIZE;r++) {
				 ladder[r]=input.readLine().split(" ");
			 	}
			 
			 for(int c1=0;c1<SIZE;c1++) {
				 if(ladder[99][c1].equals("2")) {
					 r=99;
					 c=c1;
				 }
			 }
			 
			 while(true) {
				 moveLadder();
				 
				 if(r==0) {
					 break;
				 }
			 }
			 
			 System.out.printf("#%d %d%n",test_case,c);
		}	
	}
	
	static void moveLadder() {
		int[][] deltas= {{0,-1},{0,1},{-1,0}};
		
		for(int i=0;i<deltas.length;i++) {
			int nr=r+deltas[i][0];
			int nc=c+deltas[i][1];
			
			if(isIn(nr,nc) && ladder[nr][nc].equals("1")) {
				ladder[nr][nc]="0";
				r=nr;
				c=nc;
				break;
			}
		}

	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<SIZE && c>=0 && c<SIZE;
	}
}
